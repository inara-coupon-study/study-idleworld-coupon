package com.pado.batch

import com.pado.domain.annotation.EnableDomain
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@EnableDomain
@SpringBootApplication(scanBasePackages = ["com.pado"])
@ConfigurationPropertiesScan
class BatchApplication

fun main(args: Array<String>) {
    runApplication<BatchApplication>(*args)
}
