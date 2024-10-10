//22404136 Szymon Fijalkowski
package com.TheSwiftSalmons.PixelCritic.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GameRepository extends CrudRepository<Game, Long> 
{
	List<Game> findByReleaseYear (@Param("releaseYear") int releaseYear);
	
	@Query("select g from Game g where g.releaseYear between ?1 and ?2")
	List<Game> findByReleaseYearBetween(@Param("low") int low, @Param("high") int high);
}
