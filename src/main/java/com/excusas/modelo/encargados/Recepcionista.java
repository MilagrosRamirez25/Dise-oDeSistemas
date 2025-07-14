package com.excusas.modelo.encargados;

import com.excusas.modelo.comportamiento.ComportamientoResolucion;
import com.excusas.modelo.excusas.Excusa;
import com.excusas.modelo.excusas.MotivoExcusa;

public class Recepcionista extends Encargado {

    public Recepcionista(ComportamientoResolucion comportamiento) {
        super(comportamiento);
    }

    @Override
    public boolean puedeAceptarExcusa(Excusa excusa) {
        return excusa.getMotivo() == MotivoExcusa.DORMIDO ||
                excusa.getMotivo() == MotivoExcusa.PERDI_TRANSPORTE;
    }

    @Override
    public void procesarExcusa(Excusa excusa) {
        System.out.println("Email al empleado (" + excusa.getEmpleado().getEmail() + "): La licencia fue aceptada por el motivo: " + excusa.getMotivo());
    }
}