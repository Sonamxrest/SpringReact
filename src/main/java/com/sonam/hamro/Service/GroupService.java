package com.sonam.hamro.Service;

import com.sonam.hamro.models.Group;

public interface GroupService {
    Group save(Group g);

    Group getGroupByUid(Long uid, Long id);
}
