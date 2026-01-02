package com.tuplatacrece.talentcross_prestamo.domain;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class Prestamo {
    private Long id;
    private String dni;
    private BigDecimal monto;
    private Integer visualizaciones;

    public boolean tienePrestamo() {
        return monto.compareTo(BigDecimal.ZERO) > 0;
    }
}
