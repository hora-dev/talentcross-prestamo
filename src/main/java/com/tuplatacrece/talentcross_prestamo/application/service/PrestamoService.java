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

    public void save(String dni, BigDecimal monto) {
        prestamoRepository.save(dni, monto);
    }

}
