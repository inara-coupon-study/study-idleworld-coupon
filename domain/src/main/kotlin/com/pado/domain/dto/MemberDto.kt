package com.pado.domain.dto

import org.bson.types.ObjectId

data class MemberDto (
    val id: ObjectId,
    val name: String,
)