package com.pado.domain.entity

import java.time.Instant

data class Coupon(
    val code: String,
    val metaInfo: CouponMetaInfo?, // Meta info는 잘 변하지 않는 정보이므로 coupon에 embed 시킨다.
    val createdAt: Instant = Instant.now(),
    val memberInfo: Member? = null,
    val assignedAt: Instant? = null,
    val expiredAt: Instant? = null,
)