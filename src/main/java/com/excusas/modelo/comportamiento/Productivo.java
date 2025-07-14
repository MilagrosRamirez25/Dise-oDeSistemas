package com.excusas.modelo.comportamiento;

import com.excusas.modelo.encargados.Encargado;
import com.excusas.modelo.excusas.Excusa;

public class Productivo implements ComportamientoResolucion {
    @Override
    public void resolverExcusa(Encargado encargado, Excusa excusa) {
        // Notifica al CTO
        System.out.println("Notificando al CTO: El encargado está resolviendo productivamente.");

        if (encargado.puedeAceptarExcusa(excusa)) {
            encargado.procesarExcusa(excusa);
        } else {
            encargado.pasarAlSiguiente(excusa);
        }
    }
}