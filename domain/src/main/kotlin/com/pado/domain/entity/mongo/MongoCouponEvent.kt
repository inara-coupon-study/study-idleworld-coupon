package com.pado.domain.entity.mongo

import com.pado.domain.type.EventPopupType
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "coupon_event")
class MongoCouponEvent(
    val name: String,
    val couponCount: Long,
    val type: EventPopupType?,
    val description: String?,
)