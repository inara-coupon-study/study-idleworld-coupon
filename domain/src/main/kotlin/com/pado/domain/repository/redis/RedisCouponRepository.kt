package com.pado.domain.repository.redis

import com.pado.domain.entity.redis.RedisCoupon
import org.springframework.data.repository.CrudRepository

interface RedisCouponRepository: CrudRepository<RedisCoupon, String> {
    fun findByCode(code: String): RedisCoupon?
}