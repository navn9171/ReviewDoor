package com.reviewdoor.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "companies")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String company_name;
	private int founded_in;
	private String headquarters;
	private int emp_count;

	public Company() {
	}

	public Company(int id, String company_name, int founded_in, String headquarters, int emp_count) {
		this.id = id;
		this.company_name = company_name;
		this.founded_in = founded_in;
		this.headquarters = headquarters;
		this.emp_count = emp_count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public int getFounded_in() {
		return founded_in;
	}

	public void setFounded_in(int founded_in) {
		this.founded_in = founded_in;
	}

	public String getHeadquarters() {
		return headquarters;
	}

	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}

	public int getEmp_count() {
		return emp_count;
	}

	public void setEmp_count(int emp_count) {
		this.emp_count = emp_count;
	}

	@Override
	public String toString() {
		return "Company{" +
				"id=" + id +
				", company_name='" + company_name + '\'' +
				", founded_in=" + founded_in +
				", headquarters='" + headquarters + '\'' +
				", emp_count=" + emp_count +
				'}';
	}
}
