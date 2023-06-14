package com.example.db

import com.example.db.model.Recipie

interface RoomDataSource {

    suspend fun getRecipie(items: String): List<Recipie>

    suspend fun addRecipie(recipie: Recipie)

    suspend fun updateRecipie(recipie: Recipie)

    suspend fun deleteRecipie(id: String)

}