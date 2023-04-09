package com.pado.infra.mongo.annotation
import com.pado.infra.mongo.MongoConfiguration
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(MongoConfiguration::class)
annotation class EnableMongo()
