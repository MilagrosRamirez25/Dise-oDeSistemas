package com.excusas.modelo.encargados;

import com.excusas.modelo.comportamiento.Normal;

public class LineaDeEncargados {

    public static Encargado crearLinea() {
        Encargado recepcionista = new Recepcionista(new Normal());
        Encargado supervisor = new SupervisorArea(new Normal());
        Encargado gerente = new GerenteRRHH(new Normal());
        Encargado ceo = new CEO(new Normal());
        Encargado rechazador = new Rechazador(new Normal());

        recepcionista.setSiguiente(supervisor);
        supervisor.setSiguiente(gerente);
        gerente.setSiguiente(ceo);
        ceo.setSiguiente(rechazador);

        return recepcionista;
    }
}
