package com.sonam.hamro.Repository;

import com.sonam.hamro.models.Group;
import com.sonam.hamro.models.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository {
    User findUserByUserName(String username);
    User findById(Long id);
    void saveUser(User user);

    List<User> getAllUsers();

    List<Group> getGroupOfUser(Long uid);
}
