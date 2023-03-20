package com.pado.domain.entity

import com.pado.domain.type.ExpiredPeriod
import jakarta.persistence.Id
import org.bson.types.ObjectId
import java.time.Instant

data class CouponMetaInfo(
    @Id val id: ObjectId = ObjectId.get(),
    val name: String,
    val price: Long,
    val setPieceCount: Int,
    val expiredPeriod: ExpiredPeriod,
)