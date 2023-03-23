package com.pado.domain.configuration

import com.pado.infra.rds.datasource.annotation.EnableCouponJpa
import com.pado.infra.redis.annotation.EnableMongo
import com.pado.infra.redis.annotation.EnableRedis
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["com.pado.domain"])
@ConfigurationPropertiesScan
@EnableCouponJpa
@EnableMongo
@EnableRedis
open class DomainConfig