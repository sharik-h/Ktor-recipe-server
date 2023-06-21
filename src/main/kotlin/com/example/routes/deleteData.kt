package com.example.routes

import com.example.room.RoomController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.deleteRecipie(controller: RoomController) {
    delete("/deleteRecipe") {
        val id = call.parameters["id"] ?: return@delete
        id.let {
            controller.deleteRecipie(it)
        }
        call.respond(HttpStatusCode.OK, "the data is deleted")
    }
}