package com.tuplatacrece.talentcross_prestamo;

import com.tuplatacrece.talentcross_prestamo.application.port.PrestamoRepository;
import com.tuplatacrece.talentcross_prestamo.application.service.PrestamoService;
import com.tuplatacrece.talentcross_prestamo.domain.Prestamo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Optional;

public class PrestamoTest {

    private PrestamoRepository prestamoRepository;
    private PrestamoService prestamoService;

    @BeforeEach
    void setUp() {
        prestamoRepository = Mockito.mock(PrestamoRepository.class);
        prestamoService = new PrestamoService(prestamoRepository);
    }

    @Test
    void encuentraEmpleadoConPrestamo() {
        String dni = "30123456";
        Prestamo prestamo = new Prestamo();
        prestamo.setDni(dni);
        prestamo.setMonto(new BigDecimal(10000));

        Mockito.when(prestamoService.findByDni(dni)).thenReturn(Optional.of(prestamo));
        Optional<Prestamo> prestamoOptional = prestamoService.findByDni(dni);

        Assertions.assertTrue(prestamoOptional.isPresent());
        Assertions.assertEquals(dni, prestamoOptional.get().getDni());
        Assertions.assertEquals(new BigDecimal(10000), prestamoOptional.get().getMonto());
        Assertions.assertTrue(prestamoOptional.get().tienePrestamo());
    }

    @Test
    void noEncuentraEmpleadoConPrestamo() {
        String dni = "40123456";

        Mockito.when(prestamoService.findByDni(dni)).thenReturn(Optional.empty());
        Optional<Prestamo> prestamoOptional = prestamoService.findByDni(dni);

        Assertions.assertFalse(prestamoOptional.isPresent());
    }

    @Test
    void tieneVisualizacionesDePrestamo() {
        String dni = "40123457";

        Prestamo prestamoConVisualizaciones = new Prestamo();
        prestamoConVisualizaciones.setDni(dni);
        prestamoConVisualizaciones.setMonto(new BigDecimal(10000));
        prestamoConVisualizaciones.setVisualizaciones(3);

        Mockito.when(prestamoRepository.findByDni(dni)).thenReturn(Optional.of(prestamoConVisualizaciones));

        Integer visualizaciones = prestamoService.visualizacionesPrestamo(dni);

        Assertions.assertEquals(3, visualizaciones);
    }

    @Test
    void visualizarPrestamo() {
        String dni = "40123458";

        Prestamo prestamo = new Prestamo();
        prestamo.setDni(dni);
        prestamo.setMonto(new BigDecimal(10000));
        prestamo.setVisualizaciones(0);

        Mockito.when(prestamoRepository.findByDni(dni)).thenReturn(Optional.of(prestamo));

        Prestamo prestamoVisualizacion = prestamoService.visualizarPrestamo(dni);

        Assertions.assertEquals(1, prestamoVisualizacion.getVisualizaciones());
    }
}
