package com.kidsworld.infra.rds.datasource

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import java.util.*

// Jpa에서 Audit을 하기 위한 config
@Configuration
@EnableJpaAuditing
class JpaAuditConfig {

  @Bean
  @ConditionalOnMissingBean(AuditorAware::class)
  fun auditorProvider(): AuditorAware<String>
    = AuditorAware { Optional.of("anonymous") }
}
