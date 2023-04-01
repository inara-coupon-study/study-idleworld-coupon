package com.pado.domain.repository.mongo

import com.pado.domain.entity.Coupon
import org.springframework.data.mongodb.repository.MongoRepository

interface MongoCouponRepository: MongoRepository<Coupon, String> {
    fun findByCode(code: String): Coupon?
}