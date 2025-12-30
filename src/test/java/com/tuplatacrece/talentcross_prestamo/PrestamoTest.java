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
}
