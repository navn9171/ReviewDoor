package com.reviewdoor.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String description;
	private String job_title;
	private String designation;

	@ManyToOne
	@JoinColumn(name = "company_id")
	@JsonIgnore
	private Company company;

	public Review() {
	}

	public Review(int id, String description, String job_title, String designation) {
		this.id = id;
		this.description = description;
		this.job_title = job_title;
		this.designation = designation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Review{" +
				"id=" + id +
				", description='" + description + '\'' +
				", job_title='" + job_title + '\'' +
				", designation='" + designation + '\'' +
				'}';
	}
}
