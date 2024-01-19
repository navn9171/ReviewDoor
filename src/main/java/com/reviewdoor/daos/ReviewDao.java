package com.reviewdoor.daos;

import com.reviewdoor.entities.Review;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewDao extends JpaRepository<Review, Integer> {

	@Transactional
	void deleteByCompanyId(Integer id);
}
