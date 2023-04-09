package com.pado.domain.entity.mongo

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "member")
data class MongoMember(
    val id: ObjectId,
    val name: String,
){
    companion object{
        fun toMongoMember(member: com.pado.domain.entity.Member) = MongoMember(
            id = member.id,
            name = member.name,
        )
    }

}