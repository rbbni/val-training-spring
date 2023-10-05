package com.example.valtrainingspring.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@GetMapping("/all")
	public String allAccess() {
		return "CONTENUTO PUBBLICO(NO PERMESSI)";
	}

	@GetMapping("/valutato")
	@PreAuthorize("hasRole('VALUTATO')")
	public String moderatorAccess() {
		return "CONTENUTO VISIBILE SOLO A CHI E' VALUTATO";
	}

	@GetMapping("/valutatore")
	@PreAuthorize("hasRole('VALUTATORE')")
	public String adminAccess() {
		return "CONTENUTO VISIBILE SOLO DA CHI VALUTA";
	}
}
