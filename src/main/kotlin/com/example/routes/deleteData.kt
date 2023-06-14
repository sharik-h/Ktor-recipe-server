package com.example.routes

import com.example.room.RoomController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.deleteRecipie(controller: RoomController) {
    get("/deleteRecipe") {
        val id = call.parameters["id"] ?: call.respond(HttpStatusCode.NoContent, "id parameter not available")
        id?.let {  ids ->
            controller.deleteRecipie(ids.toString())
        }
    }
}