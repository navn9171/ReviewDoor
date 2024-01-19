package com.reviewdoor.services;

import com.reviewdoor.daos.CompanyDao;
import com.reviewdoor.daos.ReviewDao;
import com.reviewdoor.entities.Company;
import com.reviewdoor.entities.Review;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReviewService {

	@Autowired
	private ReviewDao reviewDao;

	@Autowired
	private CompanyDao companyDao;

	public ResponseEntity<Review> submitReview(Integer id, Review review) {
		try{
			Company company = companyDao.findById(id)
					.orElseThrow(() -> new NoSuchElementException("Company not found with the id"+ id));

			company.getReviews().add(review);
			review.setCompany(company);
			Review savedReview = reviewDao.save(review);
			return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
			//companyDao.save(company);
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(new Review(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<Review>> getReviewsByCompanyId(Integer id) {
		List<Review> reviews = companyDao.findById(id).get().getReviews();
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}

	public ResponseEntity<?> findReviewById(Integer id) {

		try {
			Review r = reviewDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Review not found for ID " + id));
			return new ResponseEntity<>(r, HttpStatus.FOUND);
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<String> updateReview(Integer id, Review review) {
		try {
			Review r = reviewDao.findById(id).orElseThrow(() -> new EntityNotFoundException("Review not found for id " + id));

			r.setDescription(review.getDescription());
			r.setDesignation(review.getDesignation());
			r.setJob_title(review.getJob_title());
			reviewDao.save(r);

			return new ResponseEntity<>("Review Updated Successfully.", HttpStatus.OK);

		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<String> deleteReview(Integer id) {
		try {
			reviewDao.deleteById(id);
			return new ResponseEntity<>("Review Deleted Successfully", HttpStatus.OK);
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<String> deleteAllReviewsOfCompany(Integer id) {
		try {
			if (companyDao.existsById(id)){
				reviewDao.deleteByCompanyId(id);
				return new ResponseEntity<>("ALl Reviews Deleted Successfully.", HttpStatus.OK);
			}
			else{
				return new ResponseEntity<>("Company not found by ID "+ id, HttpStatus.NOT_FOUND);
			}
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
