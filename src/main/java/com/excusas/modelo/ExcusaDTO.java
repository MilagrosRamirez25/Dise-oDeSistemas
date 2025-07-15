package com.excusas.modelo;

import com.excusas.modelo.excusas.MotivoExcusa;

public class ExcusaDTO {
    private String nombre;
    private String email;
    private int legajo;
    private MotivoExcusa motivo;

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getLegajo() {
        return legajo;
    }

    public MotivoExcusa getMotivo() {
        return motivo;
    }

    // setters también si vas a recibir JSON
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public void setMotivo(MotivoExcusa motivo) {
        this.motivo = motivo;
    }
}