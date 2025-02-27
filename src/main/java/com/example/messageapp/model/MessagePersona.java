package com.example.messageapp.model;

import java.time.LocalDateTime;

public class MessagePersona {
    private Long id;
    private String user;
    private String mensaje;
    private LocalDateTime fechaCreacion;

    // Constructor vacío
    public MessagePersona() {
    }

    // Constructor con parámetros
    public MessagePersona(String user, String mensaje, LocalDateTime fechaCreacion) {
        this.user = user;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion != null ? fechaCreacion : LocalDateTime.now(); // Si no se envía, asigna la fecha actual
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "MessagePersona{" +
                "id=" + id +
                ", user='" + user + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}