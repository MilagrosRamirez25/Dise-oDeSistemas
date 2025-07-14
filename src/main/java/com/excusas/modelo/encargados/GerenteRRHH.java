package com.excusas.modelo.encargados;

import com.excusas.modelo.comportamiento.ComportamientoResolucion;
import com.excusas.modelo.excusas.Excusa;
import com.excusas.modelo.excusas.MotivoExcusa;

public class GerenteRRHH extends Encargado {

    public GerenteRRHH(ComportamientoResolucion comportamiento) {
        super(comportamiento);
    }

    @Override
    public boolean puedeAceptarExcusa(Excusa excusa) {
        return excusa.getMotivo() == MotivoExcusa.INCREIBLE;
    }

    @Override
    public void procesarExcusa(Excusa excusa) {
        System.out.println("Gerente RRHH: La excusa fue aceptada por ser increíble.");
    }
}