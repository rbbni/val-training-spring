package com.example.valtrainingspring.security.jwt;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.valtrainingspring.security.securityServices.UserDetailsServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthTokenFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			// Ottieni il token JWT dall'header Authorization (rimuovendo il prefisso "Bearer")
			String jwt = parseJwt(request);
			if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
				// Estrai il nome utente dal token JWT validato
				String username = jwtUtils.getUserNameFromJwtToken(jwt);

				// Carica i dettagli dell'utente (UserDetails) dal servizio utente personalizzato
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);

				// Crea un oggetto di autenticazione usando i dettagli dell'utente
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());

				// Imposta i dettagli aggiuntivi sull'autenticazione (come indirizzo IP, sessione, ecc.)
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				// Imposta l'autenticazione corrente nell'ambiente di sicurezza di Spring
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception e) {
			// Gestisci eventuali eccezioni e registra un errore nel caso in cui qualcosa vada storto
			logger.error("Cannot set user authentication: {}", e);
		}

		// Prosegui con la catena dei filtri
		filterChain.doFilter(request, response);
	}

	// Estrai il token JWT dall'header Authorization
	private String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader("Authorization");

		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			return headerAuth.substring(7);
		}

		return null;
	}
}
