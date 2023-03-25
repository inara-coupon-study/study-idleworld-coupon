package com.pado.infra.redis.annotation
import com.pado.infra.redis.RedisConfiguration
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(RedisConfiguration::class)
annotation class EnableRedis()
