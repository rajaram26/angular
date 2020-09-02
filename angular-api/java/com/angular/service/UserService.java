package com.angular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.model.LoginUser;
import com.angular.model.User;
import com.angular.repositary.LoginRepositary;
import com.angular.repositary.UserRepositary;

@Service
public class UserService {
	
	@Autowired
	UserRepositary userrepositary;
	
	@Autowired
	LoginRepositary loginrepositary;
	
	public List<User> findAll(){
		return (List<User>) userrepositary.findAll();
	}

	
	public List<User> findbyacc(String n){
		return (List<User>) userrepositary.findaccno(n);
	}

	public List<User> findbydate(String start, String end) {
		return (List<User>) userrepositary.findbydate(start, end);
	}

	public List<LoginUser> findAllUser() {
		
		return (List<LoginUser>) loginrepositary.findAll();
	}


	public void delete(int data) {
		loginrepositary.deleteById(data);
	}
}
