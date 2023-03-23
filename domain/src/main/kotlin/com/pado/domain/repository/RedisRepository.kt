package com.pado.domain.repository

import com.pado.domain.entity.RedisCoupon
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository

// 참고 ) https://www.hides.kr/1109

// 레디스 전략
// 참고 ) https://velog.io/@korea3611/Spring-boot-%EC%A2%8B%EC%95%84%EC%9A%94%EC%88%98-%EC%A6%9D%EA%B0%80-%EB%B6%84%EC%82%B0%EB%9D%BD%EC%9D%84-%EC%9D%B4%EC%9A%A9%ED%95%98%EC%97%AC-%EB%8F%99%EC%8B%9C%EC%84%B1-%EC%A0%9C%EC%96%B4%ED%95%98%EA%B8%B0-redis%ED%99%9C%EC%9A%A9%ED%95%98%EA%B8%B0
// 1) write through
// 2) lazy

// redis config
// 참고) https://blog.naver.com/semtul79/222235108317

// redis repository
// 참고) https://sabarada.tistory.com/106?category=856943

// 1. 대기열에 쿠폰 발급 사용자를 저장하고
// 2. 대기열 순위를 조회해 자기가 몇등인지 알 수 있게 한다.
// 3. 대기열에 있는 사람에게 순서대로 쿠폰을 할당한다.
@Repository
class RedisRepository(
    private val redisTemplate: RedisTemplate<String, Any>,
) {

    fun zAdd(key: String, value: Any, score: Double): Boolean? {
        return redisTemplate.opsForZSet().add(key, value, score)
    }

    fun zAddIfAbsent(key: String, value: Any, score: Double): Boolean? {
        return redisTemplate.opsForZSet().addIfAbsent(key, value, score)
    }

    fun <T : Any> zRange(key: String, startRank: Long, endRank: Long, type: Class<T>): Set<T>? {
        return redisTemplate.opsForZSet().range(key, startRank, endRank)
            ?.map { type.cast(it) }
            ?.toSet()
    }

    fun <T : Any> zPopMin(key: String, count: Long, type: Class<T>): Set<T>? {
        return redisTemplate.opsForZSet().popMin(key, count)
            ?.map { type.cast(it.value) }
            ?.toSet()
    }

    fun zRank(key: String, value: Any): Long? {
        return redisTemplate.opsForZSet().rank(key, value)
    }

    fun zSize(key: String): Long? {
        return redisTemplate.opsForZSet().size(key)
    }

    fun sAdd(key: String, value: Any): Long? {
        return redisTemplate.opsForSet().add(key, value)
    }

    fun sRem(key: String, value: Any): Long? {
        return redisTemplate.opsForSet().remove(key, value)
    }

    fun sCard(key: String): Long? {
        return redisTemplate.opsForSet().size(key)
    }
}