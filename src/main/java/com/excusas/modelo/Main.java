package com.excusas.modelo;

import com.excusas.modelo.comportamiento.Normal;
import com.excusas.modelo.empleados.Empleado;
import com.excusas.modelo.encargados.*;
import com.excusas.modelo.excusas.Excusa;
import com.excusas.modelo.excusas.MotivoExcusa;

public class Main {

    public static void main(String[] args) {
        // la creacion de encargados
        Encargado recepcionista = new Recepcionista(new Normal());
        Encargado supervisor = new SupervisorArea(new Normal());
        Encargado gerente = new GerenteRRHH(new Normal());
        Encargado ceo = new CEO(new Normal());
        Encargado rechazador = new Rechazador(new Normal());


        recepcionista.setSiguiente(supervisor);
        supervisor.setSiguiente(gerente);
        gerente.setSiguiente(ceo);
        ceo.setSiguiente(rechazador);

        // La creacion de empleados
        Empleado juan = new Empleado("Mili", "Mili@mail.com", 101);
        Empleado maria = new Empleado("Brisa", "Brisa@mail.com", 102);
        Empleado lucas = new Empleado("Horacio", "Horacio@mail.com", 103);
        Empleado ines = new Empleado("Abigail", "Abigail@mail.com", 104);

        Excusa excusa1 = new Excusa(juan, MotivoExcusa.DORMIDO);            // debe aceptar el Recepcionista
        Excusa excusa2 = new Excusa(maria, MotivoExcusa.FAMILIAR);          // debe aceptar el Supervisor
        Excusa excusa3 = new Excusa(lucas, MotivoExcusa.INVEROSIMIL);       // debe aceptar el CEO
        Excusa excusa4 = new Excusa(ines, null);                            // debe ser rechazada

        // se procesan las escusas :)
        System.out.println("Procesando excusa de Juan:");
        recepcionista.manejarExcusa(excusa1);
        System.out.println("\nProcesando excusa de Maria:");
        recepcionista.manejarExcusa(excusa2);
        System.out.println("\nProcesando excusa de Lucas:");
        recepcionista.manejarExcusa(excusa3);
        System.out.println("\nProcesando excusa de Inés:");
        recepcionista.manejarExcusa(excusa4);
    }
}