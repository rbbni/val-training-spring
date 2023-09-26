package com.example.valtrainingspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.valtrainingspring.model.User;
import com.example.valtrainingspring.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/mail")
	public User getByMail(@RequestParam(value = "mail")  String mail){
		return userService.findByMail(mail);
	}
}