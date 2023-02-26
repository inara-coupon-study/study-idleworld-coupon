package com.pado.domain.entity

import com.pado.domain.type.CouponType

class RiderCouponDetail(
    val type: CouponType,
    val imageUrl: String,
    val menu: String,
) : CouponDetail