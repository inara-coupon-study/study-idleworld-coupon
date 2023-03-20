package com.pado.api.controller

import com.pado.api.dto.request.CouponMetaInfoRequest
import com.pado.api.service.CouponService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CouponController(
    private val couponService: CouponService,
) {

    @GetMapping("coupon")
    fun createCoupon(
        @RequestBody request: CouponMetaInfoRequest,
        @RequestParam count: Int,
    ){
        couponService.createCoupon(metaInfo = request, count = count)
    }
}