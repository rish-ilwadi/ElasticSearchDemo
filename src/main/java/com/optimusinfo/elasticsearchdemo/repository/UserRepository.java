package com.optimusinfo.elasticsearchdemo.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.optimusinfo.elasticsearchdemo.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{

	@Query("{\"query\":{\"bool\":{\"should\":[{\"regexp\":{\"name\":\"?0.*\"}},{\"regexp\":{\"email\":\"?1.*\"}}]}}}")
	List<User> findByNameOrEmail(String name, String email);
}
