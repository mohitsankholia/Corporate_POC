package poc.basic.react.DLitheBootcampBasicPOC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poc.basic.react.DLitheBootcampBasicPOC.entity.Corporate;
import poc.basic.react.DLitheBootcampBasicPOC.service.CorporateServices;

@RestController
@RequestMapping("/rest")
public class APIController {
	
	@Autowired
	CorporateServices service;
	
	// /rest/new
	// infosys has successfully inserted
	@PostMapping("/new")
	public String happy(Corporate corp) {
		
		return service.addingNewOne(corp).getOrg()+ "has successfully inserted";
		
	}

}
