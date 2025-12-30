package com.tuplatacrece.talentcross_prestamo.infraestructure.controller;

import com.tuplatacrece.talentcross_prestamo.application.port.PrestamoRepository;
import com.tuplatacrece.talentcross_prestamo.application.service.PrestamoService;
import com.tuplatacrece.talentcross_prestamo.domain.Prestamo;
import com.tuplatacrece.talentcross_prestamo.infraestructure.dto.PrestamoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/prestamos")
@RequiredArgsConstructor
public class PrestamoController {

    private final PrestamoService prestamoService;

    @GetMapping
    public ResponseEntity<PrestamoResponseDTO> tienePrestamo(@RequestParam String dni) {
        Optional<Prestamo> prestamo = prestamoService.findByDni(dni);
        if (prestamo.isPresent()) {
            return ResponseEntity.ok(
                    new PrestamoResponseDTO(
                            prestamo.get().getMonto(), prestamo.get().tienePrestamo()));
        }
        return ResponseEntity.ok(new PrestamoResponseDTO(null, false));
    }

    @PostMapping
    public ResponseEntity<PrestamoResponseDTO> save(@RequestParam String dni, @RequestParam BigDecimal monto) {
        prestamoService.save(dni, monto);
        return ResponseEntity.ok(new PrestamoResponseDTO(monto, monto.compareTo(BigDecimal.ZERO) > 0 ));
    }
}
