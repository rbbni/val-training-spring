package com.example.valtrainingspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.valtrainingspring.model.User;
import com.example.valtrainingspring.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private final UserRepository userRepo;

	@Autowired
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}


	public User getById(Long id) {
		Optional<User> u = userRepo.findById(id);

		if (u.isEmpty()) {
			return null;
		}
		return u.get();
	}

	public User createUser(User user) {
		return userRepo.save(user);
	}

	public User updateUser(Long id, User updatedUser) {
		Optional<User> optionalUser = userRepo.findById(id);

		if (optionalUser.isPresent()) {
			User existingUser = optionalUser.get();

			// Update the properties of the existing user with the values from updatedUser
			existingUser.setName(updatedUser.getName());
			existingUser.setSurname(updatedUser.getSurname());
			// Update other properties as needed

			// Save the updated user
			return userRepo.save(existingUser);
		} else {
			// User with the given id not found
			return null;
		}

	}

	public List<User> getAll() {
		return userRepo.findAll();
	}

	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}

}
