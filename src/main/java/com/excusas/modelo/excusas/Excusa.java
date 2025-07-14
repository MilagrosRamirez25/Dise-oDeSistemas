package com.excusas.modelo.excusas;

import com.excusas.modelo.empleados.Empleado;

public class Excusa {
    private Empleado empleado;
    private MotivoExcusa motivo;

    public Excusa(Empleado empleado, MotivoExcusa motivo) {
        this.empleado = empleado;
        this.motivo = motivo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public MotivoExcusa getMotivo() {
        return motivo;
    }
}