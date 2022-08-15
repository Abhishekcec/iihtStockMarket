package com.estockmarket.company.service;

import java.util.List;

import com.estockmarket.company.model.Company;

public interface CompanyService {

	Company saveCompany(Company company);
	List<Company> getAllCompanies();
	Company getCompanyDetails(String companyCode);
	void deleteCompanyDetails(String companyCode);
}
