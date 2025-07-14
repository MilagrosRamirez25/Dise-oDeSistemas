package com.excusas.modelo.encargados;

import com.excusas.modelo.comportamiento.ComportamientoResolucion;
import com.excusas.modelo.excusas.Excusa;
import com.excusas.modelo.excusas.MotivoExcusa;

public class SupervisorArea extends Encargado {

    public SupervisorArea(ComportamientoResolucion comportamiento) {
        super(comportamiento);
    }

    @Override
    public boolean puedeAceptarExcusa(Excusa excusa) {
        return excusa.getMotivo() == MotivoExcusa.CORTE_SUMINISTRO ||
                excusa.getMotivo() == MotivoExcusa.FAMILIAR;
    }

    @Override
    public void procesarExcusa(Excusa excusa) {
        if (excusa.getMotivo() == MotivoExcusa.CORTE_SUMINISTRO) {
            System.out.println("Email a EDESUR@mailfake.com.ar: ¿Hubo un corte en el barrio?");
        } else {
            System.out.println("Email al empleado (" + excusa.getEmpleado().getEmail() + "): ¿Está todo bien con tu familiar?");
        }
    }
}