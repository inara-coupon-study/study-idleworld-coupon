package com.pado.infra.redis

import org.redisson.Redisson
import org.redisson.api.RedissonClient
import org.redisson.config.Config
import org.redisson.spring.data.connection.RedissonConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
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
    fun redissonConnectionFactory(redisson: RedissonClient): RedissonConnectionFactory {
        return RedissonConnectionFactory(redisson)
    }

    @Bean
    fun redissonClient(): RedissonClient {
        var redisson: RedissonClient?
        val config = Config()
        config.useSingleServer().address = REDISSON_HOST_PREFIX + redisHost + ":" + redisPort
        redisson = Redisson.create(config)
        return redisson
    }

    @Bean
    fun redisTemplate(): RedisTemplate<ByteArray,ByteArray>{
        val redisTemplate = RedisTemplate<ByteArray, ByteArray>()
        redisTemplate.setConnectionFactory(redissonConnectionFactory(redissonClient()))
        return redisTemplate
    }


    companion object {
        private const val REDISSON_HOST_PREFIX = "redis://"
    }
}