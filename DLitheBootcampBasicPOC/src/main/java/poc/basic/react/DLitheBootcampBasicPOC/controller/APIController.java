package poc.basic.react.DLitheBootcampBasicPOC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/")
	public List<Corporate> hogan(){
		
		return service.readEverything(); 
	}
	
	// localhost:8081//dlithebootcampjan2022/rest/amazon
	@GetMapping("/{comp}")
	public Corporate downey(@PathVariable("comp") String comp) {
		return service.readOne(comp);
	}
	
	@DeleteMapping("/remove/{id}")
	public String hemsworth(@PathVariable("id") String id) {
		return service.eraseOne(id);
	}
	
}
