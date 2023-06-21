package com.example.room

import com.example.db.RoomDataSourceImpl
import com.example.db.model.Recipie

class RoomController(
    private val dataSource: RoomDataSourceImpl
) {

    suspend fun getAllRecipie(): List<Recipie> {
        return dataSource.getRecipie()
    }

    suspend fun addRecipie(recipie: Recipie) {
        dataSource.addRecipie(recipie)
    }

    suspend fun updateRecipe(recipie: Recipie) {
        dataSource.updateRecipie(recipie)
    }

    suspend fun deleteRecipie(id: String){
        dataSource.deleteRecipie(id)
    }

}