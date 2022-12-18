package com.sonam.hamro.Service.impl;

import com.sonam.hamro.Repository.GroupRepository;
import com.sonam.hamro.Service.GroupService;
import com.sonam.hamro.models.Group;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupService;

    @Autowired
    EntityManager entityManager;

    @Override
    public Group save(Group g) {
        return groupService.save(g);
    }

    @Override
    public Group getGroupByUid(Long uid, Long id) {
        Group g = null;
        try {
            g = (Group) entityManager.createQuery("select g from Group g where (g.uidOne = :uid or g.uidTwo = :uid) and   (g.uidOne = :id or g.uidTwo = :id)")
                    .setParameter("uid", uid)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException noResultException) {
                g = new Group();
                g.setUidOne(uid);
                g.setUidTwo(id);
                g = groupService.save(g);
        }
        return g;
    }
}
