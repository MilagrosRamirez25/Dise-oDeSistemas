package com.excusas.modelo;

import com.excusas.modelo.ExcusaDTO;
import com.excusas.modelo.comportamiento.Normal;
import com.excusas.modelo.comportamiento.Vago;
import com.excusas.modelo.encargados.*;
import com.excusas.modelo.empleados.Empleado;
import com.excusas.modelo.excusas.Excusa;
import com.excusas.modelo.excusas.MotivoExcusa;
import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExcusaServiceTest {

    private ExcusaService excusaService;

    @BeforeEach
    void setup() {
        excusaService = new ExcusaService();
    }

    @Test
    @Order(1)
    public void testProcesarExcusaTrivialAceptadaPorRecepcionista() {
        ExcusaDTO dto = new ExcusaDTO();
        dto.setNombre("Mili");
        dto.setEmail("Mili@mail.com");
        dto.setLegajo(101);
        dto.setMotivo(MotivoExcusa.DORMIDO);

        excusaService.procesarExcusa(dto);

        List<Excusa> excusas = excusaService.obtenerExcusas();
        Assertions.assertFalse(excusas.isEmpty());
        Assertions.assertEquals("Mili", excusas.get(0).getEmpleado().getNombre());
        Assertions.assertEquals(MotivoExcusa.DORMIDO, excusas.get(0).getMotivo());
    }

    @Test
    @Order(2)
    public void testProcesarExcusaModeradaAceptadaPorSupervisor() {
        ExcusaDTO dto = new ExcusaDTO();
        dto.setNombre("Horacio");
        dto.setEmail("Horacio@mail.com");
        dto.setLegajo(102);
        dto.setMotivo(MotivoExcusa.FAMILIAR);

        excusaService.procesarExcusa(dto);

        List<Excusa> excusas = excusaService.obtenerExcusas();
        Assertions.assertTrue(excusas.stream().anyMatch(e -> e.getEmpleado().getNombre().equals("Luisa")));
    }

    @Test
    @Order(3)
    public void testProcesarExcusaInverosimilAceptadaPorCEO() {
        ExcusaDTO dto = new ExcusaDTO();
        dto.setNombre("Brisa");
        dto.setEmail("Brisa@mail.com");
        dto.setLegajo(103);
        dto.setMotivo(MotivoExcusa.INVEROSIMIL);

        excusaService.procesarExcusa(dto);

        List<Excusa> excusas = excusaService.obtenerExcusas();
        Assertions.assertTrue(excusas.stream().anyMatch(e -> e.getEmpleado().getNombre().equals("Pepe")));
    }

    @Test
    @Order(4)
    public void testProcesarExcusaRechazada() {
        ExcusaDTO dto = new ExcusaDTO();
        dto.setNombre("Abigail");
        dto.setEmail("Abigail@mail.com");
        dto.setLegajo(104);
        dto.setMotivo(null);

        excusaService.procesarExcusa(dto);

        List<Excusa> excusas = excusaService.obtenerExcusas();
        Assertions.assertTrue(excusas.stream().anyMatch(e -> e.getEmpleado().getNombre().equals("Ana")));
    }

    @Test
    @Order(5)
    public void testExcusaConEncargadoVago() {
        Encargado recepcionistaVago = new Recepcionista(new Vago());
        Encargado supervisorNormal = new SupervisorArea(new Normal());
        recepcionistaVago.setSiguiente(supervisorNormal);
        Encargado linea = recepcionistaVago;

        ExcusaService serviceVago = new ExcusaService() {
            {
                try {
                    var lineaField = ExcusaService.class.getDeclaredField("linea");
                    lineaField.setAccessible(true);
                    lineaField.set(this, linea);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };

        ExcusaDTO dto = new ExcusaDTO();
        dto.setNombre("Emanuel");
        dto.setEmail("Emanuel@mail.com");
        dto.setLegajo(105);
        dto.setMotivo(MotivoExcusa.DORMIDO);

        serviceVago.procesarExcusa(dto);

        List<Excusa> excusas = serviceVago.obtenerExcusas();
        Assertions.assertTrue(excusas.stream().anyMatch(e -> e.getEmpleado().getNombre().equals("Jose")));
    }
}
