package com.excusas.modelo.comportamiento;

import com.excusas.modelo.encargados.Encargado;
import com.excusas.modelo.excusas.Excusa;

public class Normal implements ComportamientoResolucion {
    @Override
    public void resolverExcusa(Encargado encargado, Excusa excusa) {
        if (encargado.puedeAceptarExcusa(excusa)) {
            encargado.procesarExcusa(excusa);
        } else {
            encargado.pasarAlSiguiente(excusa);
        }
    }
}
