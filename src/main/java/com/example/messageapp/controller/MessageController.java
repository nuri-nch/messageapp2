package com.example.messageapp.controller;

import com.example.messageapp.model.MessagePersona;
import com.example.messageapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<MessagePersona> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessagePersona> getMessageById(@PathVariable Long id) {
        Optional<MessagePersona> message = messageService.getMessageById(id);
        return message.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MessagePersona addMessage(@RequestBody MessagePersona message) {
        return messageService.addMessage(message);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        return messageService.deleteMessage(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}