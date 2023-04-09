package com.pado.domain.entity.redis

import org.bson.types.ObjectId
import org.springframework.data.redis.core.RedisHash

// coupon에서 member info까지 들고있게 되면 이 doc은 무의미. 다시 한 번 고민해보기.
@RedisHash
class RedisMemberCouponAssignment(
    val memberId: ObjectId,
    val redisCouponMetaInfo: RedisCouponMetaInfo,
    val count: Long,
) {
}