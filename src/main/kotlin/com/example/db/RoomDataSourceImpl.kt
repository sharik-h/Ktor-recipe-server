package com.example.db

import com.example.db.model.Recipie
import org.litote.kmongo.all
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.toList
import org.litote.kmongo.eq
import org.litote.kmongo.reactivestreams.KMongo
import org.litote.kmongo.reactivestreams.getCollection

class RoomDataSourceImpl(
    private val mongo: CoroutineDatabase
): RoomDataSource {

    val collection = mongo.getCollection<Recipie>()


    override suspend fun getRecipie(items: String): List<Recipie> {
        return collection.find(Recipie::items eq(items)).toList()
    }

    override suspend fun addRecipie(recipie: Recipie) {
        collection.insertOne(recipie)
    }

    override suspend fun updateRecipie(recipie: Recipie) {
        collection.updateOne(Recipie::id eq(recipie.id), recipie)
    }

    override suspend fun deleteRecipie(id: String) {
        collection.deleteOne(Recipie::id eq(id))
    }
}