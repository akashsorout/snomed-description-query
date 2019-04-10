package in.co.bytehub.snomed.searchapi.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

import in.co.bytehub.snomed.searchapi.model.Description;


@Repository
public interface DescriptionRepo extends ElasticsearchCrudRepository<Description, String>{

}
