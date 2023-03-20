package com.pado.domain.dto

import com.pado.domain.entity.CouponMetaInfo
import com.pado.domain.type.ExpiredPeriod

data class CouponMetaInfoDto(
    val name: String,
    val price: Long,
    val setPieceCount: Int,
    val expiredPeriod: ExpiredPeriod,
) {
    fun toEntity(): CouponMetaInfo = CouponMetaInfo(
        name = this.name,
        price = this.price,
        setPieceCount = this.setPieceCount,
        expiredPeriod = this.expiredPeriod,
    )
}