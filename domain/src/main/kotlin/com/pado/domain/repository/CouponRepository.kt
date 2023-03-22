package com.pado.domain.repository

import com.pado.domain.entity.Coupon
import org.springframework.data.mongodb.repository.MongoRepository

interface CouponRepository<T, U> : MongoRepository<Coupon, String> {
    fun findByCode(code: String): Coupon?
}