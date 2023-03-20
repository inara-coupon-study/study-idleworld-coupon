package com.mongodb.annotations
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(MongoConfiguration::class)
annotation class EnableMongo()
