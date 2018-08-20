package com.example.demo.springboot.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

	
	@Document(collection = "users")
	public class User {
			
		@Id
		private int id;				
		private String name;		
		private int age;
		private long mobileNumber;
		private String mailid;
		private List<String> interest;
		
		public User() {}
		public User(int id, String name, int age, long mobileNumber, String mailid, List<String> interest) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.mobileNumber = mobileNumber;
			this.mailid = mailid;
			this.interest = interest;
		}
				
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public long getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(long mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		public String getMailid() {
			return mailid;
		}
		public void setMailid(String mailid) {
			this.mailid = mailid;
		}
		
		public List<String> getInterest() {
			return interest;
		}
		public void setInterest(List<String> interest) {
			this.interest = interest;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", age=" + age + ", mobileNumber=" + mobileNumber + ", mailid="
					+ mailid + ", interest=" + interest + "]";
		}		

}
