package com.tuplatacrece.talentcross_prestamo.infraestructure.configuration;

import com.tuplatacrece.talentcross_prestamo.application.port.PrestamoRepository;
import com.tuplatacrece.talentcross_prestamo.application.service.PrestamoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public PrestamoService prestamoService(PrestamoRepository prestamoRepository) {
        return new PrestamoService(prestamoRepository);
    }
}
