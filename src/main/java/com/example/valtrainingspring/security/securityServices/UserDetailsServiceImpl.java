package com.example.valtrainingspring.security.securityServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.valtrainingspring.model.User;
import com.example.valtrainingspring.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(mail)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username(mail): " + mail));

		return UserDetailsImpl.build(user);
	}

}
