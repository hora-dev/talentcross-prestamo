    package com.tuplatacrece.talentcross_prestamo.infraestructure.mapper;

    import com.tuplatacrece.talentcross_prestamo.domain.Prestamo;
    import com.tuplatacrece.talentcross_prestamo.infraestructure.dto.PrestamoResponseDTO;
    import com.tuplatacrece.talentcross_prestamo.infraestructure.entity.PrestamoEntity;
    import org.mapstruct.Mapper;

    @Mapper(componentModel = "spring")
    public interface PrestamoMapper {

        PrestamoEntity toEntity(Prestamo prestamo);

        Prestamo toDomain(PrestamoEntity prestamoEntity);

        PrestamoResponseDTO toDTO(Prestamo prestamo);
    }