package com.sonam.hamro.Repository;

import com.sonam.hamro.models.Group;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface GroupRepository extends BaseRepository<Group, Long> {
}
