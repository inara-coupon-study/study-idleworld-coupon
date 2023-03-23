package com.pado.infra.redis.annotation
import com.pado.infra.redis.MongoConfiguration
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(MongoConfiguration::class)
annotation class EnableMongo()
