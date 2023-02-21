package com.pado.domain.configuration

import com.kidsworld.infra.rds.datasource.annotation.EnableCouponJpa
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@ComponentScan(basePackages = ["com.pado.domain"])
@ConfigurationPropertiesScan
@EnableCouponJpa
open class DomainConfig