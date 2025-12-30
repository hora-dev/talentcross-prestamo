package com.tuplatacrece.talentcross_prestamo.infraestructure.adapter;

import com.tuplatacrece.talentcross_prestamo.application.port.PrestamoRepository;
import com.tuplatacrece.talentcross_prestamo.domain.Prestamo;
import com.tuplatacrece.talentcross_prestamo.infraestructure.entity.PrestamoEntity;
import com.tuplatacrece.talentcross_prestamo.infraestructure.mapper.PrestamoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PrestamoRepositoryImpl implements PrestamoRepository {

    private final PrestamoCrudRepository prestamoCrudRepository;
    private final PrestamoMapper prestamoMapper;

    @Override
    public Optional<Prestamo> findByDni(String dni) {
        Optional<PrestamoEntity> prestamoEntity = prestamoCrudRepository.findByDni(dni);
        return prestamoEntity.map(prestamoMapper::toDomain);
    }

    @Override
    public Prestamo save(String dni, BigDecimal monto) {
        Prestamo prestamo = new Prestamo();
        prestamo.setDni(dni);
        prestamo.setMonto(monto);
        PrestamoEntity prestamoEntity = prestamoMapper.toEntity(prestamo);
        prestamoEntity = prestamoCrudRepository.save(prestamoEntity);
        return prestamoMapper.toDomain(prestamoEntity);
    }
}
