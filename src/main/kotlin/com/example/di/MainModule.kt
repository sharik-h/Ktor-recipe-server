package com.example.di

import com.example.db.RoomDataSource
import com.example.db.RoomDataSourceImpl
import com.example.room.RoomController
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module {
    single {
        KMongo.createClient()
            .coroutine
            .getDatabase("my_recipe")
    }
    single<RoomDataSourceImpl> {
        RoomDataSourceImpl(get())
    }
    single {
        RoomController(get())
    }
}