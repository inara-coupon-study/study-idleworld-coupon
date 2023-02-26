package com.pado.domain.repository

import com.pado.domain.entity.Coupon
import org.springframework.data.mongodb.repository.MongoRepository

interface CouponRepository : MongoRepository<Coupon, String> {
}