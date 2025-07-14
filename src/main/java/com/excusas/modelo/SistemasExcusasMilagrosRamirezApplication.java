package com.excusas.modelo;

import com.excusas.modelo.comportamiento.Normal;
import com.excusas.modelo.empleados.Empleado;
import com.excusas.modelo.encargados.*;
import com.excusas.modelo.excusas.Excusa;
import com.excusas.modelo.excusas.MotivoExcusa;

public class SistemasExcusasMilagrosRamirezApplication {

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
        Empleado juan = new Empleado("Mili", "Mili@mail.com", 1);
        Empleado maria = new Empleado("Brisa", "Brisa@mail.com", 2);
        Empleado lucas = new Empleado("Horacio", "Horacio@mail.com", 3);
        Empleado ines = new Empleado("Abigail", "Abigail@mail.com", 4);

        Excusa excusa1 = new Excusa(juan, MotivoExcusa.DORMIDO);
        Excusa excusa2 = new Excusa(maria, MotivoExcusa.FAMILIAR);
        Excusa excusa3 = new Excusa(lucas, MotivoExcusa.INVEROSIMIL);
        Excusa excusa4 = new Excusa(ines, null);

        // se procesan las escusas :)
        System.out.println("Procesando excusa de Mili:");
        recepcionista.manejarExcusa(excusa1);
        System.out.println("\nProcesando excusa de Brisa:");
        recepcionista.manejarExcusa(excusa2);
        System.out.println("\nProcesando excusa de Horacio:");
        recepcionista.manejarExcusa(excusa3);
        System.out.println("\nProcesando excusa de Abigail:");
        recepcionista.manejarExcusa(excusa4);
    }
}