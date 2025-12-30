package com.tuplatacrece.talentcross_prestamo.infraestructure.dto;

import java.math.BigDecimal;

public record PrestamoResponseDTO(BigDecimal monto, Boolean tienePrestamo) {
}