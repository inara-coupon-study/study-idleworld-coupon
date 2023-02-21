package com.kidsworld.infra.mongo.annotation

import com.kidsworld.infra.mongo.MongoConfiguration
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(MongoConfiguration::class)
annotation class EnableMongo()
