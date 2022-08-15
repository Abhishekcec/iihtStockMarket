package com.estockmarket.company.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.estockmarket.company.exception.ResourceNotFoundException;
import com.estockmarket.company.model.Company;
import com.estockmarket.company.repository.CompanyRepository;
import com.estockmarket.company.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	private CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	@Override
	public Company saveCompany(Company company) {
		String code = createCompanyCode(company.getCompanyName());
		
		company.setCompanyCode(code);
		return companyRepository.save(company);
	}

	@Override
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}

	@Override
	public Company getCompanyDetails(String companyCode) {
		return companyRepository.findById(companyCode).orElseThrow(() -> 
			new ResourceNotFoundException("Company", "companyCode", companyCode));
		
	}

	@Override
	public void deleteCompanyDetails(String companyCode) {
		companyRepository.findById(companyCode).orElseThrow(() -> 
		new ResourceNotFoundException("Company", "companyCode", companyCode));
		companyRepository.deleteById(companyCode);
	}
	
	private String createCompanyCode(String companyName) {
		String companyCode1 = companyName.substring(0, 3).concat("%");
		int count = companyRepository.getCompanyCount(companyCode1);
		String code = String.format("%03d", count);
		
		String companyCode = companyName.substring(0, 3).concat(code);
		System.out.println("final code: "+companyCode );
		return companyCode;
		
	}

}
