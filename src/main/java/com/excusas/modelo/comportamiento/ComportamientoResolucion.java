package com.excusas.modelo.comportamiento;

import com.excusas.modelo.encargados.Encargado;
import com.excusas.modelo.excusas.Excusa;

public interface ComportamientoResolucion {
    void resolverExcusa(Encargado encargado, Excusa excusa);
}