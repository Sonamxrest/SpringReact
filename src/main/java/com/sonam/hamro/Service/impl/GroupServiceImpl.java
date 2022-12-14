package com.sonam.hamro.Service.impl;

import com.sonam.hamro.Repository.GroupRepository;
import com.sonam.hamro.Service.GroupService;
import com.sonam.hamro.models.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupService;
    @Override
    public Group save(Group g) {
        return groupService.save(g);
    }
}
