package com.pado.domain.dto

import com.pado.domain.entity.CouponMetaInfo
import com.pado.domain.type.CouponGrade
import com.pado.domain.type.ExpiredPeriodUnit

data class CouponMetaInfoDto(
    val name: String,
    val price: Long,
    val setPieceCount: Int,
    val expiredPeriodUnit: ExpiredPeriodUnit,
    val expiredPeriodNumber: Int,
    val couponGrade: CouponGrade? = null,
) {
    fun toEntity(): CouponMetaInfo = CouponMetaInfo(
        name = this.name,
        price = this.price,
        setPieceCount = this.setPieceCount,
        expiredPeriodUnit = this.expiredPeriodUnit,
        expiredPeriodNumber = this.expiredPeriodNumber,
        couponGrade = this.couponGrade,
    )
}