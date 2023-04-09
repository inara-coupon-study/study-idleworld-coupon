package com.pado.domain.entity.mongo

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "coupon_stock")
class MongoCouponStock(
    val couponMetaInfoId: ObjectId,
    val count: Long,
)