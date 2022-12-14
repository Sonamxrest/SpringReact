package com.sonam.hamro.Controllers;

import com.sonam.hamro.Service.UserService;
import com.sonam.hamro.config.JWTUtils;
import com.sonam.hamro.models.User;
import com.sonam.hamro.persitDto.UserPersitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder encoder;


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody UserPersitDto userPersitDto) {
        if (userPersitDto.getId() == null) {
            userPersitDto.setPassword(encoder.encode(userPersitDto.getPassword()));
        }
        userService.saveUser(userPersitDto);
        return new ResponseEntity(userPersitDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        return new ResponseEntity(userService.getOne(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/login")
    private ResponseEntity<?> login(@RequestBody Map<String, String> customer) {
        User customer1 = (User) userService.loadUserByUsername(customer.get("username"));
        if (encoder.matches(customer.get("password"), customer1.getPassword())) {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(customer1, customer.get("username"), customer1.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(authenticationToken));
            Map<String, Object> map = new HashMap<>();
            map.put("token", JWTUtils.encode(customer.get("username")));
            map.put("id", customer1.getId());
            map.put("username", customer1.getUsername());
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
