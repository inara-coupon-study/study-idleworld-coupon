package com.pado.domain.entity

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document


data class Member(
    val id: ObjectId,
    val name: String,
)