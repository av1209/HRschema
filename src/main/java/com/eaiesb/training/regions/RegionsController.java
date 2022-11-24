package com.eaiesb.training.regions;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/api/v2")

public class RegionsController {
	
	@Autowired
	private RegionsRepository regRepo;
	
	@GetMapping("/regions")
	public List <Regions> getAllregions(){
		return regRepo.findAll();
		}
	
	@GetMapping("/regions/{id}")
	public Optional <Regions> getRegionsById(@PathVariable String id){
		return regRepo.findById(id);
	}
	
	@PostMapping("/regions")
	public Regions saveRegions(@RequestBody Regions region) {
		return regRepo.save(region);
	}
	
	@PutMapping("/regions/{id}")
	public Regions update(@PathVariable String id,@Validated @RequestBody Regions region) {
		region.setId(id);
		return regRepo.save(region);
	}
	
	@DeleteMapping("/regions/{id}")
	public void deleteRegion(@PathVariable String id) {
		regRepo.deleteById(id);
	}

}
