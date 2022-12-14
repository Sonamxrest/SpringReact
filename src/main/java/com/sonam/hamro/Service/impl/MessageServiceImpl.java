package com.sonam.hamro.Service.impl;

import com.sonam.hamro.Repository.MessageRepository;
import com.sonam.hamro.Service.MessageService;
import com.sonam.hamro.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;
    @Override
    public Message save(Message m) {
        return messageRepository.save(m);
    }
}
