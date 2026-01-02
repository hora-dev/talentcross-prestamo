package com.tuplatacrece.talentcross_prestamo.application.port;

import com.tuplatacrece.talentcross_prestamo.domain.Prestamo;

import java.math.BigDecimal;
import java.util.Optional;

public interface PrestamoRepository {
    Optional<Prestamo> findByDni(String dni);
    Prestamo save(String dni, BigDecimal monto, Integer visualizaciones);
    Prestamo updateVisualizaciones(String dni, Integer visualizaciones);
    Prestamo getPrestamo(String dni);
}
