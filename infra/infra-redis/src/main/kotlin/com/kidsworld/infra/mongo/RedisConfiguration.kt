package com.mongodb.annotations

import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories


@Configuration
@EnableRedisRepositories
class RedisConfiguration
