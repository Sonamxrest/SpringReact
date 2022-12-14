package com.sonam.hamro.Service;

import com.sonam.hamro.models.User;
import com.sonam.hamro.persitDto.UserPersitDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void saveUser(UserPersitDto userPersitDto);
    User getOne(Long id);
    List<User> getAll();
}
