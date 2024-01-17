package com.reviewdoor.services;

import com.reviewdoor.daos.CompanyDao;
import com.reviewdoor.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CompanyService {

	@Autowired
	private CompanyDao companyDao;

	public Company createCompany(Company company) {
		Company comp = companyDao.save(company);

		return comp;
	}

	public List<Company> getAllCompanies() {
		List<Company> allCompanies = companyDao.findAll();
		return allCompanies;
	}

	public Company updateCompanyDetails(Integer id, Company company) {
		Company c = companyDao.findById(id).orElseThrow(() -> new NoSuchElementException("No Company found for id" + id));

		c.setCompany_name(company.getCompany_name());
		c.setEmp_count(company.getEmp_count());
		c.setFounded_in(company.getFounded_in());
		c.setHeadquarters(company.getHeadquarters());
		Company savedObj = companyDao.save(c);

		return savedObj;
	}

	public String deleteCompany(Integer id){
		try {
			companyDao.deleteById(id);
			return "Company Deleted Successfully";
		}
		catch(Exception e){
			return "Something went wrong!";
		}
	}
}
