package com.excusas.modelo.encargados;

import com.excusas.modelo.comportamiento.ComportamientoResolucion;
import com.excusas.modelo.excusas.Excusa;

public abstract class Encargado {

    protected Encargado siguiente;
    protected ComportamientoResolucion comportamiento;

    public Encargado(ComportamientoResolucion comportamiento) {
        this.comportamiento = comportamiento;
    }

    public void setSiguiente(Encargado siguiente) {
        this.siguiente = siguiente;
    }

    public void manejarExcusa(Excusa excusa) {
        comportamiento.resolverExcusa(this, excusa);
    }

    public void pasarAlSiguiente(Excusa excusa) {
        if (siguiente != null) {
            siguiente.manejarExcusa(excusa);
        } else {
            System.out.println("Excusa rechazada: necesitamos pruebas contundentes.");
        }
    }

    public abstract boolean puedeAceptarExcusa(Excusa excusa);

    public abstract void procesarExcusa(Excusa excusa);
}