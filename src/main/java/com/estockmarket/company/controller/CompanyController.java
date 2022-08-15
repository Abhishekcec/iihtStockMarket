package com.estockmarket.company.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estockmarket.company.model.Company;
import com.estockmarket.company.service.CompanyService;

@RestController
@RequestMapping("/api/v1.0/market/company")
public class CompanyController {
	
	private CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
	
	@PostMapping(value="/register")
	public ResponseEntity<Company> saveCompany(@RequestBody Company company){
		return new ResponseEntity<Company>(companyService.saveCompany(company), HttpStatus.CREATED);
		
	}
	
	@GetMapping(value="/getall")
	List<Company> getAllCompanies(){
		return companyService.getAllCompanies();
	}
	
	@GetMapping(value="/info/{companyCode}")
	public ResponseEntity<Company> getCompanyDetails(@PathVariable("companyCode") String companyCode){
		return new ResponseEntity<Company>(companyService.getCompanyDetails(companyCode), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/delete/{companyCode}")
	public ResponseEntity<String> deleteCompanyDetails(@PathVariable("companyCode") String companyCode){
		companyService.deleteCompanyDetails(companyCode);
		return new ResponseEntity<String>("Company deleted successfully!.", HttpStatus.OK);
	}
  
}
