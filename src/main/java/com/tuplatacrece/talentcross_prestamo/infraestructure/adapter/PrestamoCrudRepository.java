package com.tuplatacrece.talentcross_prestamo.infraestructure.adapter;

import com.tuplatacrece.talentcross_prestamo.infraestructure.entity.PrestamoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PrestamoCrudRepository extends CrudRepository<PrestamoEntity, Long> {
    Optional<PrestamoEntity> findByDni(String dni);
}
