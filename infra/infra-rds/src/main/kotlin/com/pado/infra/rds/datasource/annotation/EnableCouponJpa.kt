package com.pado.infra.rds.datasource.annotation

import com.pado.infra.rds.datasource.DisplayDbConfig
import com.pado.infra.rds.datasource.JpaAuditConfig
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(DisplayDbConfig::class, JpaAuditConfig::class)
annotation class EnableCouponJpa()
