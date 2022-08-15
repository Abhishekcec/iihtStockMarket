package com.estockmarket.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.estockmarket.company.model.Company;

public interface CompanyRepository extends JpaRepository<Company, String>{

//	List<String> getCompanyNames();
	
	@Query("select count(*) from Company where companyName like :companyCode")
	int getCompanyCount(String companyCode);

}
