package com.pado.infra.redis.annotation
import com.pado.infra.redis.RedisConfiguration
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(RedisConfiguration::class)
//@EnableCaching
annotation class EnableRedis()
