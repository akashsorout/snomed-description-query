package com.akashsol.snomed.searchapi.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

import com.akashsol.snomed.searchapi.model.Description;


@Repository
public interface DescriptionRepo extends ElasticsearchCrudRepository<Description, String>{

}
