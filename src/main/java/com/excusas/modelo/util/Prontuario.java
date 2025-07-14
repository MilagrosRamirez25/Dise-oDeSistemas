package com.excusas.modelo.util;

public class Prontuario {
    private String nombre;
    private String email;
    private int legajo;
    private String motivo;

    public Prontuario(String nombre, String email, int legajo, String motivo) {
        this.nombre = nombre;
        this.email = email;
        this.legajo = legajo;
        this.motivo = motivo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getLegajo() {
        return legajo;
    }

    public String getMotivo() {
        return motivo;
    }
}