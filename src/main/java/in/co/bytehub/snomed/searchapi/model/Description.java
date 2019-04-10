package in.co.bytehub.snomed.searchapi.model;

import org.springframework.data.elasticsearch.annotations.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@Document(indexName = "snomedct", type = "description")
@ApiModel(value="Description Component",description="Core component of SNOMED CT to describe a concept")
public class Description extends CoreComponent{
		
		private	String conceptId;
		private	String languageCode;
		
		@ApiModelProperty(value="Type of Description <br>FSN : 900000000000003001 <br>Synonym : 900000000000013009",position=1)
		private	String typeId;
		
		@ApiModelProperty(required=true,value="Clinical term present in SNOMED CT : fever",position=0)
		private	String term;
		private	String caseSignificanceId;
		
		public Description() {
		
		}
		
		
		public Description(String id,String effectiveTime, int active, String moduleId,String conceptId, String languageCode, String typeId, String term, String caseSignificanceId) {
			super( id, effectiveTime,  active,  moduleId);
			this.conceptId = conceptId;
			this.languageCode = languageCode;
			this.typeId = typeId;
			this.term = term;
			this.caseSignificanceId = caseSignificanceId;
		}


		public String getConceptId() {
			return conceptId;
		}


		public void setConceptId(String conceptId) {
			this.conceptId = conceptId;
		}


		public String getLanguageCode() {
			return languageCode;
		}


		public void setLanguageCode(String languageCode) {
			this.languageCode = languageCode;
		}


		public String getTypeId() {
			return typeId;
		}


		public void setTypeId(String typeId) {
			this.typeId = typeId;
		}


		public String getTerm() {
			return term;
		}


		public void setTerm(String term) {
			this.term = term;
		}


		public String getCaseSignificanceId() {
			return caseSignificanceId;
		}


		public void setCaseSignificanceId(String caseSignificanceId) {
			this.caseSignificanceId = caseSignificanceId;
		}
		
		
	
}
