package com.example.db.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class Recipie(
    val name: String,
    val procedure: String,
    val items: String,
    val time: String,
    @BsonId
    val id: String = ObjectId().toString()
)
