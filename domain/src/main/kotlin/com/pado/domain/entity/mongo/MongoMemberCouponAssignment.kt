package com.pado.domain.entity.mongo

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document

// coupon에서 member info까지 들고있게 되면 이 doc은 무의미. 다시 한 번 고민해보기.
@Document(collection = "member_coupon_assignment")
class MongoMemberCouponAssignment(
    val memberId: ObjectId,
    val mongoCouponMetaInfo: MongoCouponMetaInfo,
    val count: Long,
) {
}