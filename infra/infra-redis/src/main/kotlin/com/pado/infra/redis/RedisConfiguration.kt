package com.pado.infra.redis

import org.redisson.Redisson
import org.redisson.api.RedissonClient
import org.redisson.config.Config
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories


@Configuration
@EnableRedisRepositories(basePackages = arrayOf("com.pado.domain.repository.redis"))
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

    @Bean
    fun redisTemplate(): RedisTemplate<ByteArray,ByteArray>{
        val redisTemplate = RedisTemplate<ByteArray, ByteArray>()
        redisTemplate.setConnectionFactory(redisConnectionFactory())
        return redisTemplate
    }

    @Bean
    fun redisConnectionFactory(): RedisConnectionFactory {
        return LettuceConnectionFactory(redisHost, redisPort)
    }

    companion object {
        private const val REDISSON_HOST_PREFIX = "redis://"
    }
}