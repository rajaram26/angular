package com.angular.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.angular.model.LoginUser;
import com.angular.model.User;
import com.angular.repositary.LoginRepositary;
import com.angular.service.FileServiceImp;
import com.angular.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AngularAPI {
	
	@Autowired
	LoginRepositary loginrepositary;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	FileServiceImp fileserviceimp;
	
	@GetMapping("/alluser")
	public List<LoginUser>  adduser() {
		return userservice.findAllUser();
	}
	
	@PostMapping("/adduser")
	public LoginUser adduser( @RequestBody LoginUser loginuser) {
		return loginrepositary.save(loginuser);
	}
	
	@DeleteMapping("/deleteuser/{data}")
	public boolean deleteuser(@PathVariable("data") int data) {
		userservice.delete(data);
		return true;
	}

	@GetMapping("/searchaccno/{data}")
	public List<User> findUser(@PathVariable("data") String data){
		return userservice.findbyacc(data);
	}
	
	@GetMapping("/searchdate/{start}/{end}")
	public List<User> findbydate(@PathVariable("start") String start,@PathVariable("end") String end){
		if(end.length()==0)
		{
			end=start;
		}
		System.out.println(start);
		System.out.println(end);
		String s[]=start.split("-");
		String s1[]=end.split("-");
		start="";
		end="";
		String month="";
		if(s[1].equals("01"))
		{
			month="Jan";
		}else if(s[1].equals("02")) {
			month="Feb";
		}else if(s[1].equals("03")) {
			month="Mar";
		}else if(s[1].equals("04")) {
			month="Apr";
		}else if(s[1].equals("05")) {
			month="May";
		}else if(s[1].equals("06")) {
			month="Jun";
		}else if(s[1].equals("07")) {
			month="Jul";
		}else if(s[1].equals("08")) {
			month="Aug";
		}else if(s[1].equals("09")) {
			month="Sep";
		}else if(s[1].equals("10")) {
			month="Oct";
		}else if(s[1].equals("11")) {
			month="Nov";
		}else if(s[1].equals("12")) {
			month="Dec";
		}
		
		String month1="";
		if(s1[1].equals("01"))
		{
			month1="Jan";
		}else if(s1[1].equals("02")) {
			month1="Feb";
		}else if(s1[1].equals("03")) {
			month1="Mar";
		}else if(s1[1].equals("04")) {
			month1="Apr";
		}else if(s1[1].equals("05")) {
			month1="May";
		}else if(s1[1].equals("06")) {
			month1="Jun";
		}else if(s1[1].equals("07")) {
			month1="Jul";
		}else if(s1[1].equals("08")) {
			month1="Aug";
		}else if(s1[1].equals("09")) {
			month1="Sep";
		}else if(s1[1].equals("10")) {
			month1="Oct";
		}else if(s1[1].equals("11")) {
			month1="Nov";
		}else if(s1[1].equals("12")) {
			month1="Dec";
		}
		start=s[2]+'-'+month+'-'+s[0].substring(2);
		end=s1[2]+'-'+month1+'-'+s1[0].substring(2);
		System.out.println(start);
		System.out.println(end);
		
		return userservice.findbydate(start,end);
	}
}
