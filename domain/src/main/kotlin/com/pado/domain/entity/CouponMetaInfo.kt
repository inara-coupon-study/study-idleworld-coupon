package com.pado.domain.entity

import com.pado.domain.type.CouponGrade
import com.pado.domain.type.ExpiredPeriodUnit
import jakarta.persistence.Id
import org.bson.types.ObjectId

data class CouponMetaInfo(
    @Id val id: ObjectId = ObjectId.get(),
    val name: String,
    val price: Long,
    val setPieceCount: Int,
    val expiredPeriodUnit: ExpiredPeriodUnit,
    val expiredPeriodNumber: Int,
    val couponGrade: CouponGrade,
)