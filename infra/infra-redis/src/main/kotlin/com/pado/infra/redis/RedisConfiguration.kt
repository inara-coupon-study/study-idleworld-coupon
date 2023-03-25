package com.pado.infra.redis

import org.redisson.Redisson
import org.redisson.api.RedissonClient
import org.redisson.config.Config
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class RedisConfiguration {
//    @Value("\${spring.data.redis.host}")
    // todo: yml value 주입 에러
    private val redisHost: String? = "127.0.0.1"

//    @Value("\${spring.data.redis.port}")
    private val redisPort = 6379
    @Bean
    fun redissonClient(): RedissonClient? {
        var redisson: RedissonClient? = null
        val config = Config()
        config.useSingleServer().address = REDISSON_HOST_PREFIX + redisHost + ":" + redisPort
        redisson = Redisson.create(config)
        return redisson
    }

    companion object {
        private const val REDISSON_HOST_PREFIX = "redis://"
    }
}