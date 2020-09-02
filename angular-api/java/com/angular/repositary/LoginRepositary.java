package com.angular.repositary;

import org.springframework.data.repository.CrudRepository;

import com.angular.model.LoginUser;
import com.angular.model.User;

public interface LoginRepositary extends CrudRepository<LoginUser, Integer> {

	
}
