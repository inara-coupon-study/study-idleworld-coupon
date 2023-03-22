package com.pado.domain.entity

import jakarta.persistence.Id
import org.springframework.data.redis.core.RedisHash
import java.time.Instant

@RedisHash("redis_coupon")
class RedisCoupon(
    @Id
    val code: String,
    val metaInfo: CouponMetaInfo?, // Meta info는 잘 변하지 않는 정보이므로 coupon에 embed 시킨다.
    val createdAt: Instant = Instant.now(),
    val memberInfo: Member? = null,
    val assignedAt: Instant? = null,
    val expiredAt: Instant? = null,
)
