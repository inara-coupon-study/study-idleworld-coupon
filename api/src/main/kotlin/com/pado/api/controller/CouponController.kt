package com.pado.api.controller

import com.pado.api.dto.request.CreateCouponRequest
import com.pado.api.service.CouponService
import org.springframework.web.bind.annotation.*

@RestController
class CouponController(
    private val couponService: CouponService,
) {

    @PostMapping("coupon")
    fun createCoupon(
        @RequestBody request: CreateCouponRequest,
    ){
        couponService.createCoupon(request = request)
    }
}