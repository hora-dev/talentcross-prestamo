package com.tuplatacrece.talentcross_prestamo.application.service;

import com.tuplatacrece.talentcross_prestamo.application.port.PrestamoRepository;
import com.tuplatacrece.talentcross_prestamo.domain.Prestamo;

import java.math.BigDecimal;
import java.util.Optional;

public class PrestamoService {

    private final PrestamoRepository prestamoRepository;

    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    public Optional<Prestamo> findByDni(String dni) {
        return prestamoRepository.findByDni(dni);
    }

    public Prestamo save(String dni, BigDecimal monto, Integer visualizaciones) {
        return prestamoRepository.save(dni, monto, visualizaciones);
    }

    public Integer visualizacionesPrestamo(String dni) {
        Optional<Prestamo> prestamo = prestamoRepository.findByDni(dni);
        if(prestamo.isPresent()) {
            return prestamo.get().getVisualizaciones();
        }
        return 0;
    }

    public Prestamo visualizarPrestamo(String dni) {
        Optional<Prestamo> prestamo = prestamoRepository.findByDni(dni);
        if(prestamo.isPresent()) {
            prestamo.get().setVisualizaciones(prestamo.get().getVisualizaciones() + 1);
            prestamoRepository.updateVisualizaciones(dni, prestamo.get().getVisualizaciones());
            return prestamo.get();
        }
        return new Prestamo();
    }

    public Prestamo getPrestamo(String dni) {
        Optional<Prestamo> prestamo = prestamoRepository.findByDni(dni);
        return prestamo.orElseGet(Prestamo::new);
    }


}
