package com.pado.api.dto.request
import com.pado.domain.dto.CouponMetaInfoDto
import com.pado.domain.type.ExpiredPeriod

data class CouponMetaInfoRequest(
    val name: String,
    val price: Long,
    val setPieceCount: Int,
    val expiredPeriod: String,
) {
    companion object {
        fun toDto(request: CouponMetaInfoRequest) = CouponMetaInfoDto(
            name = request.name,
            price = request.price,
            setPieceCount = request.setPieceCount,
            expiredPeriod = ExpiredPeriod.of(name = request.expiredPeriod),
        )
    }
}
