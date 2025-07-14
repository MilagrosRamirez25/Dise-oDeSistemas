package com.excusas.modelo.comportamiento;


import com.excusas.modelo.encargados.Encargado;
import com.excusas.modelo.excusas.Excusa;

public class Vago implements ComportamientoResolucion {
    @Override
    public void resolverExcusa(Encargado encargado, Excusa excusa) {
        // Siempre pasa al siguiente, no hace nada
        encargado.pasarAlSiguiente(excusa);
    }
}