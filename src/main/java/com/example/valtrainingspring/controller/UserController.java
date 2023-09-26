package com.example.valtrainingspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.valtrainingspring.model.User;
import com.example.valtrainingspring.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.getAll();
	}

	@GetMapping("/{id}")
	public User getById(@PathVariable Long id) {
		return userService.getById(id);
	}

	@GetMapping("/mail")
	public User getByMail(@RequestParam(value = "mail") String mail) {
		return userService.getByMail(mail);
	}

}
