package com.pado.domain.repository.redis

import com.pado.domain.entity.Coupon
import org.springframework.data.repository.CrudRepository

interface RedisCouponRepository: CrudRepository<Coupon, String> {
    fun findByCode(code: String): Coupon?
}