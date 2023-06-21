package com.example.db

import com.example.db.model.Recipie

interface RoomDataSource {

    suspend fun getRecipie(): List<Recipie>

    suspend fun addRecipie(recipie: Recipie)

    suspend fun updateRecipie(recipie: Recipie)

    suspend fun deleteRecipie(id: String)

}