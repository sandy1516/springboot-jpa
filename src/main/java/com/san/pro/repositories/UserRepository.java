package com.san.pro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.san.pro.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	public static final String testQuery = "SELECT * FROM [Test].[dbo].[user] ";

	@Query(value = testQuery, nativeQuery = true)
	List<User> findAll();
	
	@Query(value = testQuery + "where name = ?", nativeQuery = true)
	User findByName(String name);
}