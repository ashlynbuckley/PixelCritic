//Ashlyn
package com.TheSwiftSalmons.PixelCritic.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReviewRepository extends CrudRepository<Review, Long> {
	 
	List<Review> findByGameId (@Param("gameId") Long gameId);
	
	@Query("select r from Review r where r.rating between ?1 and ?2")
	List<Review> findByRatingBetween(@Param("low") int low, @Param("high") int high);
}
