package com.angular.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.angular.model.User;

public interface UserRepositary extends CrudRepository<User, String>{
	
	@Query(value="SELECT * FROM client_details WHERE date BETWEEN ?1 and ?2 order by date asc",nativeQuery=true)
	List<User> findbydate(String start,String end);

	@Query(value="SELECT * FROM client_details WHERE accno=?1 order by date asc",nativeQuery=true)
	List<User> findaccno(String name);

}
