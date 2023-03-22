package com.mongodb.annotations
import org.springframework.context.annotation.Import
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(RedisConfiguration::class)
annotation class EnableRedis()
