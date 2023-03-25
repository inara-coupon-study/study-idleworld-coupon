package com.pado.api.dto.request
import com.pado.domain.dto.CouponMetaInfoDto
import com.pado.domain.type.CouponGrade
import com.pado.domain.type.ExpiredPeriodUnit

data class CreateCouponRequest(
    val name: String,
    val price: Long,
    val setPieceCount: Int,
    val expiredPeriodUnit: String,
    val expiredPeriodNumber: Int,
    val couponGrade: String,
    val count: Int,
) {
    companion object {
        fun toDto(request: CreateCouponRequest) = CouponMetaInfoDto(
            name = request.name,
            price = request.price,
            setPieceCount = request.setPieceCount,
            // dto로 변환시 of 메서드를 통해 Enum으로 변환. 서비스 내부에서부터는 enum으로 값을 관리할 수 있도록!
            expiredPeriodUnit = ExpiredPeriodUnit.of(name = request.expiredPeriodUnit),
            expiredPeriodNumber = request.expiredPeriodNumber,
            couponGrade = CouponGrade.of(name = request.couponGrade)
        )
    }
}


