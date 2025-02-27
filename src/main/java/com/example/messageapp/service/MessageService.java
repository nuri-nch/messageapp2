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

    // Constructor 
    public MessageService() {
        
        MessagePersona message1 = new MessagePersona("Carlos", "Mensaje de prueba", LocalDateTime.now());
        message1.setId(nextId++);
        messages.add(message1);

        
        MessagePersona message2 = new MessagePersona("Ana", "aqui va mensaje", LocalDateTime.now());
        message2.setId(nextId++);
        messages.add(message2);
    }

    // Obtener todos los mensajes
    public List<MessagePersona> getAllMessages() {
        System.out.println("Mensajes almacenados: " + messages);
        return messages;
    }

    // Obtener mensaje por ID
    public Optional<MessagePersona> getMessageById(Long id) {
        return messages.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst();
    }

    // Crear nuevo mensaje
    public MessagePersona addMessage(MessagePersona message) {
        message.setId(nextId++);
        if (message.getFechaCreacion() == null) {
            message.setFechaCreacion(LocalDateTime.now());
        }
        messages.add(message);
        System.out.println("Mensaje añadido: " + message);
        return message;
    }

    // Eliminar mensaje por ID
    public boolean deleteMessage(Long id) {
        Optional<MessagePersona> mensajeEncontrado = getMessageById(id);
        if (mensajeEncontrado.isPresent()) {
            messages.remove(mensajeEncontrado.get());
            System.out.println("Mensaje eliminado con id: " + id);
            return true;
        }
        System.out.println("Mensaje con id " + id + " no encontrado.");
        return false;
    }
}
