package com.pado.domain.entity

import com.pado.domain.type.CouponType

class KakaoCouponDetail(
    val type: CouponType,
    val imageUrl: String,
    val store: String,
) : CouponDetail