package com.pado.domain.annotation

import com.pado.domain.configuration.DomainConfig
import org.springframework.context.annotation.Import


@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(DomainConfig::class)
annotation class EnableDomain()
