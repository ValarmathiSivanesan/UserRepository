package com.example.demo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.springboot.model.User;
import com.example.demo.springboot.repository.UserRepository;
import com.example.demo.springboot.services.UserServices;


	@RestController
	public class UserController {			
		
		@Autowired
		UserServices userServices;
			
		
		@RequestMapping("/AddingUsers")
		public void addUser(@RequestBody User user){
			userServices.addUser(user);
		}		
		
		@GetMapping("/UserDetails")
		public void getUsers(){
			userServices.getUsers();
		}
		
		@GetMapping("/UserDetailsIn")
		public void getByList(){
			userServices.getByList();
		}
				
		@GetMapping("/UserAge")
		public void getByAge(){
			userServices.getByAge();
		}
		
		
		
		
		
		
		
		
		/*@GetMapping("/UserAge")
		public List<User> getByAge(){
		Query query1 = new Query();
		query1.addCriteria(
                   Criteria.where("age").exists(true).andOperator(
		           Criteria.where("age").gt(10),
                   Criteria.where("age").lt(40)
	            )
                );
		List<User> userTest1 = mongoTemplate.find(query1, User.class);
		return userTest1;
		} */
		
		
		
		/*@GetMapping("/UserDetailsNotIn")
		public List<User> getByListOfUserNotIn(){
		Query query4 = new Query();
		query4.addCriteria(Criteria.where("age").nin(30));
		List<User> userTest4 = mongotemplate.find(query4, User.class);
		return userTest4;
		}
		
		@GetMapping("/UserDetailsSorting")
		public List<User> getByUserSorting(){
		Query query5 = new Query();
		query5.addCriteria(Criteria.where("age").gte(10));
		query5.with(new Sort(Sort.Direction.DESC, "age"));
		List<User> userTest5 = mongotemplate.find(query5, User.class);
		return userTest5;
		}
		
		@GetMapping("/UserNamesCheck")
		public List<User> getByUserName(){
		Query query6 = new Query();
		query6.addCriteria(Criteria.where("name").regex("M.*a","i"));
		List<User> userTest6 = mongotemplate.find(query6, User.class);
		return userTest6;
		}
						
		@PutMapping("/UpdateFirstByName")
		String updateFirstMethod(){
			Query query = new Query();
			query.addCriteria(Criteria.where("age").is(21));
			Update update = new Update();
			update.set("age", 20);
			mongotemplate.updateFirst(query, update, User.class);
			return "Updated the field age with user's name";			
		}		
				
		
		@PutMapping("/UpdateMultiByName")
		String updateMultiMethod(){
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is("Vizhi"));
			Update update = new Update();
			update.set("name", "Malar");
			mongotemplate.updateMulti(query, update, User.class);
			return "Updated the field name with user's name";			
		}		
		
		@PutMapping("/FindAndModifyByName")
			String findAndModifyMethod(){
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is("Mathi"));
			Update update = new Update();
			update.set("name", "Valarmathi");
			mongotemplate.findAndModify(query, update, User.class);
			return "Find and Modify the field is worked ";
		}
				
		@PutMapping("/UpsertByName")
			String upsertMethod(){
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is("Valar"));
			Update updateval = new Update();
			updateval.set("name", "Flora");
			mongotemplate.upsert(query, updateval, User.class);
			mongotemplate.update(User.class);
			return "Upsert Method works properly";
		}
		
		@DeleteMapping("/Delete")
			String deleteMethod(){
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is("Valarmathi"));
			User usertest=mongotemplate.findAndRemove(query, User.class);
			System.out.println(usertest);
			return "Deleted Sucessfully";
		}				
		
		
		@GetMapping("/AllUserDetails")
		public List<User> getByUserDetails(){
		Query query = new Query();
		query.addCriteria(Criteria.where("name").regex("M.*a","i").orOperator(Criteria.where("age").in(30,22)));						
		List<User> user1 = mongotemplate.find(query, User.class);		
		return user1;						
		}
		
		
		@RequestMapping(value = "/{age}/{mailid}/{id}", method=RequestMethod.GET)
		@ResponseBody
		public List<User> getByUserVal(@PathVariable("age") int age,@PathVariable("mailid") String mailid,@PathVariable("id") int id,@RequestParam("interest") List<String> interest){	
			User user=new User();
			Scanner sc=new Scanner(System.in);
			String newName=sc.next();
			int newAge=sc.nextInt();
			String newMailid=sc.next();
			int newId=sc.nextInt();
			user.setName(name);
			user.setAge(age);
			user.setMailid(mailid);
			user.setId(id);			
			Query query=new Query();				
				
			query.addCriteria(Criteria.where("id").is(id).andOperator(
					Criteria.where("age").gt(age),(
					Criteria.where("interest").in(interest)).orOperator(Criteria.where("age").is(age),(
							Criteria.where("interest").in(interest)))));
			query.with(new Sort(Sort.Direction.DESC, "age"));
				System.out.println(query.toString());					
		//List<User> user1 = mongotemplate.find(query, User.class);		
		return mongotemplate.find(query, User.class);
		}
		
		*/
		
		
	}
		
		

