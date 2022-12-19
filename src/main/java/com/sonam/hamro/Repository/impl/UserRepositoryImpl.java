package com.sonam.hamro.Repository.impl;

import com.sonam.hamro.Repository.UserRepository;
import com.sonam.hamro.models.Group;
import com.sonam.hamro.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findUserByUserName(String username) {
        try {
            return (User) entityManager.createQuery("SELECT u from User u where username =:username")
                    .setParameter("username", username).getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        }
    }

    @Override
    public User findById(Long id) {
        User use = (User) entityManager.createQuery("SELECT u from User u where id = :id")
                .setParameter("id", id).getSingleResult();
        use.setGroups(this.getGroupOfUser(id));
        return use;
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public List<Group> getGroupOfUser(Long uid) {
        return (List<Group>)
                entityManager
                        .createQuery("SELECT g FROM Group g where uidOne = :one or uidTwo = :one ", Group.class)
                        .setParameter("one", uid).getResultList();
    }
}
