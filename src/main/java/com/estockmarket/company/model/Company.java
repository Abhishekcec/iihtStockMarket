package com.estockmarket.company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="company")
public class Company {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="id")
	private String id;
	
	@Column(name="company_code", unique=true)
	private String companyCode;
	
	@Column(name="company_name", unique=true)
	private @NotNull String companyName;
	
	@Column(name="company_ceo")
	private String companyCEO;
	
	@Column(name="company_website")
	private String companyWebsite;
	
	@Min(10000000)
	@Column(name="company_turnover")
	private Double companyTurnover;
	
	@Column(name="related_stock")
	private String relatedStock;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCEO() {
		return companyCEO;
	}

	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}

	public String getCompanyWebsite() {
		return companyWebsite;
	}

	public void setCompanyWebsite(String companyWebsite) {
		this.companyWebsite = companyWebsite;
	}

	public Double getCompanyTurnover() {
		return companyTurnover;
	}

	public void setCompanyTurnover(Double companyTurnover) {
		this.companyTurnover = companyTurnover;
	}

	public String getRelatedStock() {
		return relatedStock;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public void setRelatedStock(String relatedStock) {
		this.relatedStock = relatedStock;
	}
	
	
}