package com.tuplatacrece.talentcross_prestamo.infraestructure.controller;

import com.tuplatacrece.talentcross_prestamo.application.service.PrestamoService;
import com.tuplatacrece.talentcross_prestamo.domain.Prestamo;
import com.tuplatacrece.talentcross_prestamo.infraestructure.dto.PrestamoResponseDTO;
import com.tuplatacrece.talentcross_prestamo.infraestructure.dto.TienePrestamoResponseDTO;
import com.tuplatacrece.talentcross_prestamo.infraestructure.mapper.PrestamoMapper;
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
    private final PrestamoMapper prestamoMapper;

    @GetMapping
    public ResponseEntity<TienePrestamoResponseDTO> tienePrestamo(@RequestParam String dni) {
        Optional<Prestamo> prestamo = prestamoService.findByDni(dni);
        if (prestamo.isPresent()) {
            return ResponseEntity.ok(
                    new TienePrestamoResponseDTO(
                            prestamo.get().getMonto(), prestamo.get().tienePrestamo()));
        }
        return ResponseEntity.ok(new TienePrestamoResponseDTO(null, false));
    }

    @PostMapping
    public ResponseEntity<PrestamoResponseDTO> save(@RequestParam String dni, @RequestParam BigDecimal monto, @RequestParam Integer visualizaciones) {
        Prestamo prestamo = prestamoService.save(dni, monto, visualizaciones);
        return ResponseEntity.ok(prestamoMapper.toDTO(prestamo));
    }

    @GetMapping("/visualizaciones")
    public ResponseEntity<Integer> visualizacionesPrestamo(@RequestParam String dni) {
        return ResponseEntity.ok(prestamoService.visualizacionesPrestamo(dni));
    }

    @GetMapping("/visualizar")
    public ResponseEntity<PrestamoResponseDTO> visualizarPrestamo(@RequestParam String dni) {
        return ResponseEntity.ok(prestamoMapper.toDTO(prestamoService.visualizarPrestamo(dni)));
    }
}
