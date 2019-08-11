package in.co.bytehub.snomed.searchapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.bytehub.snomed.searchapi.model.Description;
import in.co.bytehub.snomed.searchapi.repo.DescriptionRepo;

@Service
public class LoaderService {

	@Autowired
	private DescriptionRepo elasticRepo;

	public void loadData(List<Description> descriptionLst) {
		elasticRepo.save(descriptionLst);
	}

	public void loadData(Description description) {
		elasticRepo.save(description);
	}

}
