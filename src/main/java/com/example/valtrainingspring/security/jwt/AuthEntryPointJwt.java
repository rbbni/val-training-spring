package com.example.valtrainingspring.security.jwt;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

	private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

	// we override the commence() method. This method will be triggerd anytime
	// unauthenticated User requests a secured HTTP resource and an
	// AuthenticationException is thrown.
	// Questo metodo gestisce le richieste non autorizzate
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// Registra un messaggio di errore nel caso di accesso non autorizzato
		logger.error("Errore non autorizzato: {}", authException.getMessage());

		// Invia una risposta HTTP con stato 401 (Unauthorized) e un messaggio di errore
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Errore: Non autorizzato");
	}
}
