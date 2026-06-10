package com.ems.common.filter;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ems.common.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		System.out.println("In  service filter ");
		String authHeader = request.getHeader("Authorization");

		System.out.println("In doFilter method " + authHeader);
		System.out.println("In doFilter method " + request.getRequestURI());

		String token = null;
		String email = null;

		if (authHeader != null && authHeader.startsWith("Bearer ")) {

			token = authHeader.substring(7);

			try {
				email = jwtUtil.extractEmail(token);
			} catch (Exception e) {
				response.setStatus(401);
				response.getWriter().write("Invalid token or expired token");
				return;
			}
		}

		if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			if (jwtUtil.validateToken(token)) {

				String role = jwtUtil.extractRole(token);

				List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + role));

				UsernamePasswordAuthenticationToken authToken = 
						new UsernamePasswordAuthenticationToken(
								email,
								null,
								authorities);

				

				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}

		filterChain.doFilter(request, response);
	}
}