package com.pado.domain.entity.redis

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import java.time.Instant

@RedisHash
data class RedisCoupon(
    @Id val code: String,
    val metaInfo: RedisCouponMetaInfo?, // Meta info는 잘 변하지 않는 정보이므로 coupon에 embed 시킨다.
    val createdAt: Instant = Instant.now(),
    val redisMemberInfo: RedisMember? = null,
    val assignedAt: Instant? = null,
    val expiredAt: Instant? = null,
){
    companion object{
        fun toRedisCoupon(coupon: com.pado.domain.entity.Coupon) = RedisCoupon(
            code = coupon.code,
            metaInfo = coupon.metaInfo?.let { RedisCouponMetaInfo.toRedisCouponMetaInfo(it) },
            createdAt = coupon.createdAt,
            redisMemberInfo = coupon.memberInfo?.let { RedisMember.toRedisMember(it) },
            assignedAt = coupon.assignedAt,
            expiredAt = coupon.expiredAt,
        )
    }
}