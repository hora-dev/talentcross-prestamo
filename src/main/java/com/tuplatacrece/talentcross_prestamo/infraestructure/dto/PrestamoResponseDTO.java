package com.tuplatacrece.talentcross_prestamo.infraestructure.dto;

import java.math.BigDecimal;

public record PrestamoResponseDTO(Long id, String dni, BigDecimal monto, Integer visualizaciones) { }
