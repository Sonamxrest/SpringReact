package com.sonam.hamro.Repository;

import com.sonam.hamro.models.Group;
import com.sonam.hamro.models.User;
import jakarta.transaction.Transactional;

import java.util.List;

public interface UserRepository {
    User findUserByUserName(String username);
    User findById(Long id);
    void saveUser(User user);

    List<User> getAllUsers();

    List<Group> getGroupOfUser(Long uid);
}
