package com.example.messageapp.service;

import com.example.messageapp.model.MessagePersona;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    private final List<MessagePersona> messages = new ArrayList<>();
    private Long nextId = 1L;

    // Constructor con un mensaje de prueba
    public MessageService(){
    messages.add(new MessagePersona(nextId++, "nombreuser", "este es el mensaje", "1/1/2025"));
}

public List<MessagePersona> getAllMessages() {
    System.out.println(messages);  // Añadir esta línea para depurar
    return messages;
}

    public Optional<MessagePersona> getMessageById(Long id) {
        return messages.stream().filter(m -> m.getId().equals(id)).findFirst();
    }

    public MessagePersona addMessage(MessagePersona message) {
        message.setId(nextId++);
        message.setFechaCreacion(LocalDateTime.now()); // Agrega la fecha automáticamente
        messages.add(message);
        return message;
    }

    public boolean deleteMessage(Long id) {
        return messages.removeIf(m -> m.getId().equals(id));
    }
}