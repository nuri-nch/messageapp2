package com.example.messageapp.model;

public class MessagePersona {
    private Long id;
    private String user;
    private String mensaje;
    private String fechaCreacion;

    // Constructor vacío
    public MessagePersona() {}

    // Constructor con parámetros
    public MessagePersona(Long id, String user, String mensaje, String fechaCreacion) {
        this.id = id;
        this.user = user;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
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

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}