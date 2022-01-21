package poc.basic.react.DLitheBootcampBasicPOC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poc.basic.react.DLitheBootcampBasicPOC.entity.Corporate;
import poc.basic.react.DLitheBootcampBasicPOC.repository.CorporateRepository;

@Service
public class CorporateServices {

	@Autowired //get the instance/memory of the component
	CorporateRepository repo;
	
	public Corporate addingNewOne(Corporate object) {
		return repo.save(object); // pass the entity object that can be converted as record in the table
		
	}
}
