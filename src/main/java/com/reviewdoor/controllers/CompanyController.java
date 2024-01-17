package com.reviewdoor.controllers;

import com.reviewdoor.entities.Company;
import com.reviewdoor.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@PostMapping("addCompany")
	public Company createCompany(@RequestBody Company company){
		System.out.println(company);
		Company createdCompany = companyService.createCompany(company);

		return createdCompany;
	}

	@GetMapping("allCompanies")
	public List<Company> getAllCompanies(){
		return companyService.getAllCompanies();
	}

	@PutMapping("updateCompany/{id}")
	public Company updateCompanyDetails(@PathVariable("id") Integer id, @RequestBody Company company){
//		System.out.println(id);
//		System.out.println(company);
		Company updatedCompany = companyService.updateCompanyDetails(id, company);
		return updatedCompany;
	}

	@DeleteMapping("delete/{id}")
	public String deleteCompany(@PathVariable("id") Integer id){
		return companyService.deleteCompany(id);
	}
}
