package com.sonam.hamro.Repository;

import com.sonam.hamro.models.Message;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends BaseRepository<Message, Long> {
}
