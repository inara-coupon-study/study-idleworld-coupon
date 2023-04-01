package com.pado.api.service

import com.pado.api.dto.request.CreateCouponRequest
import com.pado.domain.service.CouponCommandService
import org.springframework.stereotype.Service

/**
    RESPONSE / REQUEST에서 DTO로 변환하는 단계를 포함하는 레이어.
    save 전까지는 내부적으로 변환된 DTO를 사용한다.
 */
@Service
class CouponService(
    private val couponCommandService: CouponCommandService,
) {
    fun createCoupon(request: CreateCouponRequest,) {
        couponCommandService.createAndSave(CreateCouponRequest.toDto(request = request), count = request.count)
    }

}