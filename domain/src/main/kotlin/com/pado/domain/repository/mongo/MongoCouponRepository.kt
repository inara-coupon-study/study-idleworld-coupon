package com.pado.domain.repository.mongo

import com.pado.domain.entity.mongo.MongoCoupon
import org.springframework.data.mongodb.repository.MongoRepository

interface MongoCouponRepository: MongoRepository<MongoCoupon, String> {
    fun findByCode(code: String): MongoCoupon?
}