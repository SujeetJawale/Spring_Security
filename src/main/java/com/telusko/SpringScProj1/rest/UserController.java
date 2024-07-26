package com.telusko.SpringScProj1.rest;

import com.telusko.SpringScProj1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.SpringScProj1.dao.Users;

@RestController
public class UserController 
{
	@Autowired
	private UserService service;
	
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
	
	@PostMapping("registeru")
	public Users register(@RequestBody Users user)
	{
		//String pass=user.getPassword();
//		String encoded = encoder.encode(user.getPassword());
//		System.out.println(encoded);
//		user.setPassword(encoded);
		user.setPassword(encoder.encode(user.getPassword()));
		System.out.println(user.getPassword());
		return service.saveTheUser(user);
		
	}
	@GetMapping("info")
	public String getInfo()
	{
		return "example resource ";
	}

}
