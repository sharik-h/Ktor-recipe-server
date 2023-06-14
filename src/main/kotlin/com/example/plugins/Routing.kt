package com.example.plugins

import com.example.room.RoomController
import com.example.routes.deleteRecipie
import com.example.routes.getRecipies
import com.example.routes.inserData
import com.example.routes.update
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val controller by inject<RoomController>()
    routing {
        inserData(controller)
        getRecipies(controller)
        deleteRecipie(controller)
        update(controller)
    }
}
