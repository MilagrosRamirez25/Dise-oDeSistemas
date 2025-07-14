package com.excusas.modelo;

import com.excusas.modelo.comportamiento.Normal;
import com.excusas.modelo.comportamiento.Vago;
import com.excusas.modelo.empleados.Empleado;
import com.excusas.modelo.encargados.*;
import com.excusas.modelo.excusas.Excusa;
import com.excusas.modelo.excusas.MotivoExcusa;
import com.excusas.modelo.util.AdministradorDeProntuarios;
import com.excusas.modelo.util.Prontuario;
import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ManejoExcusasTest {

    Empleado empleadoTrivial;
    Empleado empleadoModerado;
    Empleado empleadoCreativo;
    Empleado empleadoRechazado;

    Recepcionista recepcionista;
    SupervisorArea supervisor;
    GerenteRRHH gerente;
    CEO ceo;
    Rechazador rechazador;

    @BeforeEach
    public void setup() {
        // Empleados
        empleadoTrivial = new Empleado("Juan", "juan@mail.com", 101);
        empleadoModerado = new Empleado("Luisa", "luisa@mail.com", 102);
        empleadoCreativo = new Empleado("Pepe", "pepe@mail.com", 103);
        empleadoRechazado = new Empleado("Ana", "ana@mail.com", 104);

        // Encargados
        recepcionista = new Recepcionista(new Normal());
        supervisor = new SupervisorArea(new Normal());
        gerente = new GerenteRRHH(new Normal());
        ceo = new CEO(new Normal());
        rechazador = new Rechazador(new Normal());

        // Cadena de responsabilidad
        recepcionista.setSiguiente(supervisor);
        supervisor.setSiguiente(gerente);
        gerente.setSiguiente(ceo);
        ceo.setSiguiente(rechazador);
    }

    @Test
    @Order(1)
    public void testExcusaTrivialAceptadaPorRecepcionista() {
        Excusa excusa = new Excusa(empleadoTrivial, MotivoExcusa.DORMIDO);
        recepcionista.manejarExcusa(excusa);

        // No hay asserts porque el sistema imprime a consola, pero esperamos "licencia fue aceptada"
    }

    @Test
    @Order(2)
    public void testExcusaModeradaAceptadaPorSupervisor() {
        Excusa excusa = new Excusa(empleadoModerado, MotivoExcusa.CORTE_SUMINISTRO);
        recepcionista.manejarExcusa(excusa);
        // Esperamos "Email a EDESUR"
    }

    @Test
    @Order(3)
    public void testExcusaInverosimilAceptadaPorCEOYProntuario() {
        Excusa excusa = new Excusa(empleadoCreativo, MotivoExcusa.INVEROSIMIL);
        recepcionista.manejarExcusa(excusa);

        List<Prontuario> prontuarios = AdministradorDeProntuarios.getInstancia()
                .getClass()
                .getDeclaredFields().length > 0 ? List.of() : null; // No accedemos a la lista, validamos por consola
    }

    @Test
    @Order(4)
    public void testExcusaRechazada() {
        Excusa excusa = new Excusa(empleadoRechazado, null); // null a propósito
        recepcionista.manejarExcusa(excusa);
        // Esperamos: "Excusa rechazada: necesitamos pruebas contundentes."
    }

    @Test
    @Order(5)
    public void testEncargadoVagoNoProcesa() {
        Recepcionista recepcionistaVago = new Recepcionista(new Vago());
        recepcionistaVago.setSiguiente(supervisor);
        Excusa excusa = new Excusa(empleadoTrivial, MotivoExcusa.DORMIDO);
        recepcionistaVago.manejarExcusa(excusa);
        // Esperamos que no la acepte él, sino el supervisor (que no puede, entonces sigue)
    }
}