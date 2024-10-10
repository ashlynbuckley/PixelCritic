//Avalon
package com.TheSwiftSalmons.PixelCritic.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DeveloperRepository extends CrudRepository<Developer, Long> {
	
	List<Developer> findByDeveloperId (@Param("developerId") Long developerId);
	
	@Query("select d from Developer d where d.developerName = :name")
	List<Developer> findByName(@Param("name") String name);
}
