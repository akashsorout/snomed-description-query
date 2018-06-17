package com.akashsol.snomed.searchapi.config;

import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

@Configuration
public class ElasticSearchConfig {
	
	@Bean
	public ElasticsearchOperations elasticsearchTemplate(){
		return new ElasticsearchTemplate(new NodeBuilder().local(true).node().client());
	}
}
