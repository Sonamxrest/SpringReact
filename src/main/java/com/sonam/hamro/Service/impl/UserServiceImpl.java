package com.sonam.hamro.Service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sonam.hamro.Repository.UserRepository;
import com.sonam.hamro.Service.UserService;
import com.sonam.hamro.models.User;
import com.sonam.hamro.persitDto.UserPersitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUserName(username);
    }

    @Override
    public void saveUser(UserPersitDto userPersitDto) {
        userRepository.saveUser(objectMapper.convertValue(userPersitDto, User.class));
    }

    @Override
    public User getOne(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAllUsers();
    }
}
