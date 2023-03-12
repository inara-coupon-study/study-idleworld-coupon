package com.pado.domain.entity

import org.bson.types.ObjectId
import java.time.Instant

data class CouponMetaInfo(
    val id: ObjectId,
    val name: String,
    val price: Long,
    val setPieceCount: Int,
    val expiredDate: Instant,
)