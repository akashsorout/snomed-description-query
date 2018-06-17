package com.akashsol.snomed.searchapi.service;

import java.text.ParseException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.akashsol.snomed.searchapi.model.Description;
import com.akashsol.snomed.searchapi.repo.DescriptionRepo;
import com.akashsol.snomed.searchapi.util.ResponseModel;
import com.akashsol.snomed.searchapi.util.SearchResultModel;
import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class DescriptionSearchService {

	@Autowired
	private	DescriptionRepo  descriptionRepo;
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	

	public ResponseModel<Description> getDescriptions(String term, String typeId) {
	
		 BoolQueryBuilder bqb=new BoolQueryBuilder();
		
		term=term.trim().replaceAll(" +", " ");
		
		Arrays.asList(term.split(" ")).forEach(sterm -> 	
		
			bqb.must(QueryBuilders.queryStringQuery(sterm.trim()+"*").field("term").analyzeWildcard(true)
			.defaultOperator(org.elasticsearch.index.query.QueryStringQueryBuilder.Operator.AND))
			
				);
		
		
					NativeSearchQueryBuilder qBuild =new NativeSearchQueryBuilder().withQuery(bqb);
			
					if(typeId!=null)		
						qBuild.withFilter(QueryBuilders.termQuery("typeId", typeId));
						
			SearchQuery query=qBuild.build();
					
			return elasticsearchTemplate.query(query, new ResultsExtractor<ResponseModel<Description>>() {

			    @Override
			    public ResponseModel<Description> extract(SearchResponse response) {
			    	
			    		ResponseModel<Description> res = new ResponseModel<Description>();
			        long totalHits = response.getHits().totalHits();
			        res.setCount(totalHits);
			        List<SearchResultModel<Description>> lstHitResult = new LinkedList<SearchResultModel<Description>>();
			        
			        ObjectMapper mapper = new ObjectMapper();
			        Description description = null;
			        SearchResultModel<Description> hitResult = null;
			        
			        for (SearchHit hit : response.getHits()) {
			            if (hit != null) {
					            	
					            	description = mapper.convertValue(hit.getSource(), Description.class);
					            	
					            	hitResult = new SearchResultModel<Description>();
					            	hitResult.setComponent(description);
					            	hitResult.setScore(hit.getScore());
					            	
					            	lstHitResult.add(hitResult);
			            	
			            }
			        }
			        res.setHitResults(lstHitResult);
			        return res;
			    }
			});
			  
	}
	
	@PostConstruct
	public  void loadData() throws ParseException {
		
		elasticsearchTemplate.deleteIndex("snomedct");
		
		List<Description> lstDescforIndex =Arrays.asList(
				new Description("2075011","20020131", 1, "900000000000207008", "602001", "en", "900000000000013009", "Ross river fever", "900000000000017005"),
				new Description("3572010", "20020131", 1, "900000000000207008", "1475003", "en", "900000000000013009", "Fever blister", "900000000000020002"),
				new Description("44007011", "20020131", 1, "900000000000207008", "26275000", "en", "900000000000013009", "Fever due to Leptospira autumnalis", "900000000000020002"),
				new Description("514391014", "20020131", 1, "900000000000207008", "135882008", "en", "900000000000003001", "Feverish cold (finding)", "900000000000020002"),
				new Description("514392019", "20020131", 1, "900000000000207008", "135883003", "en", "900000000000003001", "Cough with fever (finding)", "900000000000020002")
				);
		
		
		lstDescforIndex.forEach(desc -> descriptionRepo.save(desc));
		

	};
	
}
