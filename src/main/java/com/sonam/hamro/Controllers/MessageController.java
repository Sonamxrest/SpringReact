package com.sonam.hamro.Controllers;

import com.sonam.hamro.Service.GroupService;
import com.sonam.hamro.Service.MessageService;
import com.sonam.hamro.models.Group;
import com.sonam.hamro.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/v1/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private SimpMessagingTemplate simpleMessageTemplate;
    @Autowired
    private GroupService groupService;

    @PostMapping("/createGroup")
    private ResponseEntity<?> createGroup(@RequestBody Group g) {
        return new ResponseEntity<>(groupService.save(g), HttpStatus.OK);
    }

    @GetMapping("/get/group/{uid}/{id}")
    public ResponseEntity<?> getGroup(@PathVariable("uid") Long uid, @PathVariable("id") Long id) {
        return  new ResponseEntity(groupService.getGroupByUid(uid,id), HttpStatus.OK);
    }


    @PostMapping("/sendMessage")
    private ResponseEntity<?> sendMessage(@RequestBody Message message) {
        simpleMessageTemplate.convertAndSend("/message/receive/"
                        + (Objects.equals(message.getGroup().getUidOne(),
                        message.getFrom()) ?
                        message.getGroup().getUidTwo()
                        : message.getGroup().getUidOne())
                , message);
        return new ResponseEntity(messageService.save(message), HttpStatus.OK);
    }


}
