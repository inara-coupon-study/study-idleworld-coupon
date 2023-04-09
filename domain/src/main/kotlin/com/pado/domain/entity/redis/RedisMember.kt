package com.pado.domain.entity.redis

import org.bson.types.ObjectId
import org.springframework.data.redis.core.RedisHash

@RedisHash
data class RedisMember(
    val id: ObjectId,
    val name: String,
){
    companion object{
        fun toRedisMember(member: com.pado.domain.entity.Member) = RedisMember(
            id = member.id,
            name = member.name,
        )
    }
}