package com.excusas.modelo.encargados;

import com.excusas.modelo.comportamiento.ComportamientoResolucion;
import com.excusas.modelo.excusas.Excusa;
import com.excusas.modelo.excusas.MotivoExcusa;
import com.excusas.modelo.util.AdministradorDeProntuarios;
import com.excusas.modelo.util.ObservadorCEO;
import com.excusas.modelo.util.Prontuario;

public class CEO extends Encargado implements ObservadorCEO {

    public CEO(ComportamientoResolucion comportamiento) {
        super(comportamiento);
        AdministradorDeProntuarios.getInstancia().agregarObservador(this);
    }

    @Override
    public boolean puedeAceptarExcusa(Excusa excusa) {
        return excusa.getMotivo() == MotivoExcusa.INVEROSIMIL;
    }

    @Override
    public void procesarExcusa(Excusa excusa) {
        System.out.println("Email al empleado (" + excusa.getEmpleado().getEmail() + "): Aprobado por creatividad.");
        Prontuario p = new Prontuario(
                excusa.getEmpleado().getNombre(),
                excusa.getEmpleado().getEmail(),
                excusa.getEmpleado().getLegajo(),
                excusa.getMotivo().name()
        );
        AdministradorDeProntuarios.getInstancia().registrarProntuario(p);
    }

    @Override
    public void notificarNuevoProntuario(Prontuario prontuario) {
        System.out.println("CEO notificado de nuevo prontuario: " + prontuario.getNombre() + " - " + prontuario.getMotivo());
    }
}