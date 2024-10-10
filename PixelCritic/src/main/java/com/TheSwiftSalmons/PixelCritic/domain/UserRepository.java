//Conor Salmon
package com.TheSwiftSalmons.PixelCritic.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findByUsername(@Param("username") String username);
	
	@Query("select u from User u where u.email = :email")
	List<User> findByEmail(@Param("email") String email);
}
