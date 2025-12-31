package com.tuplatacrece.talentcross_prestamo.infraestructure.dto;

import java.math.BigDecimal;

public record TienePrestamoResponseDTO(BigDecimal monto, Boolean tienePrestamo) {
}