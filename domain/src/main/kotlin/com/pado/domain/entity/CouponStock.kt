package com.pado.domain.entity

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "coupon_stock")
class CouponStock(
    val couponMetaInfoId: ObjectId,
    val count: Long,
)