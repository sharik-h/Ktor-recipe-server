package com.example.db.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class Recipie(
    @BsonId
    val id: String = ObjectId().toString(),
    val name: String,
    val time: String,
    val timeType: String,
    val image: String,
    val serving: String,
    val procedure: List<String>,
    val items: List<Pair<String, String>>,
    val level: String
)