package poc.basic.react.DLitheBootcampBasicPOC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poc.basic.react.DLitheBootcampBasicPOC.entity.Corporate;
import poc.basic.react.DLitheBootcampBasicPOC.service.CorporateServices;

@RestController
@RequestMapping("/rest")
// inform the backend and accept the req from url of react
@CrossOrigin(origins = "http://localhost:3000")

public class APIController {
	
	@Autowired
	CorporateServices service;
	
	// /rest/new
	// infosys has successfully inserted
	@PostMapping("/new")
	public String happy(@RequestBody Corporate corp) {
		
		return service.addingNewOne(corp).getOrg()+ "has successfully inserted";
		
	}

}
