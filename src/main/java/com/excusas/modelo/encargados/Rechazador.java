package com.excusas.modelo.encargados;

import com.excusas.modelo.comportamiento.ComportamientoResolucion;
import com.excusas.modelo.excusas.Excusa;

public class Rechazador extends Encargado {

    public Rechazador(ComportamientoResolucion comportamiento) {
        super(comportamiento);
    }

    @Override
    public boolean puedeAceptarExcusa(Excusa excusa) {
        return false; // Nunca acepta nada
    }

    @Override
    public void procesarExcusa(Excusa excusa) {
        System.out.println("Excusa rechazada por el Rechazador.");
    }

    @Override
    public void manejarExcusa(Excusa excusa) {
        System.out.println("Excusa rechazada: necesitamos pruebas contundentes.");
    }
}