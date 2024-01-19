package com.reviewdoor.controllers;

import com.reviewdoor.entities.Review;
import com.reviewdoor.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@PostMapping("company/{id}/review")
	public ResponseEntity<Review> submitReview(@PathVariable(name = "id") Integer id, @RequestBody Review review){
		return reviewService.submitReview(id, review);
	}

	@GetMapping("company/{id}/reviews")
	public ResponseEntity<List<Review>> getReviewsByCompanyId(@PathVariable(name = "id") Integer id){
		return reviewService.getReviewsByCompanyId(id);
	}

	@GetMapping("reviews/{review_id}")
	public ResponseEntity<?> findReviewById(@PathVariable(name = "review_id") Integer id){
		return reviewService.findReviewById(id);
	}

	@PutMapping("reviews/{id}")
	public ResponseEntity<String> updateReview(@PathVariable(name = "id") Integer id, @RequestBody Review review){
		return reviewService.updateReview(id, review);
	}

	@DeleteMapping("reviews/{id}")
	public ResponseEntity<String> deleteReview(@PathVariable(name = "id") Integer id){
		return reviewService.deleteReview(id);
	}

	@DeleteMapping("company/{company_id}/reviews")
	public ResponseEntity<String> deleteAllReviewsOfCompany(@PathVariable(name = "company_id") Integer id){
		return reviewService.deleteAllReviewsOfCompany(id);
	}
}
