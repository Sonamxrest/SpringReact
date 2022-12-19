package com.sonam.hamro.config;

import com.sonam.hamro.Repository.UserRepository;
import com.sonam.hamro.Service.UserService;
import com.sonam.hamro.models.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.util.ArrayList;

@Configuration
public class WebSecurityFilter extends GenericFilterBean {
    @Autowired
    private UserService userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String header = httpServletRequest.getHeader(JWTUtils.headerType);
        if (!ObjectUtils.isEmpty(header) && header.contains(JWTUtils.tokenType)) {
            String token = header.substring(7);
            String username = JWTUtils.decode(token);
            if (!ObjectUtils.isEmpty(username)) {
                User user = (User) userRepository.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, user.getUsername(), new ArrayList<>());
                Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request, response);
    }
}
