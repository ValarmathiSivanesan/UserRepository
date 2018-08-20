package com.example.demo.springboot.repository;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.springboot.model.User;

@Repository
public class UserRepository{
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public User addUser(User user){
        mongoTemplate.save(user);
        return user;
	}
	
	public List<User> findAllUsers(){
		return mongoTemplate.findAll(User.class);
		
	}
	
	public List<User> getByListOfUserIn(){
		Query query = new Query();
		query.addCriteria(Criteria.where("age").in(30,22));
		return mongoTemplate.find(query, User.class);		
	}
	
	public List<User> getByAge(){
		Query query1 = new Query();
		query1.addCriteria(
                   Criteria.where("age").exists(true).andOperator(
		           Criteria.where("age").gt(10),
                   Criteria.where("age").lt(40)
	            )
                );
		return mongoTemplate.find(query1, User.class);
	}	
}
