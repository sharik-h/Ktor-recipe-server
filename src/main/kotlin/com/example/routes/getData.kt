package com.example.routes

import com.example.room.RoomController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getRecipies(controller: RoomController) {
    get("/getRecipes") {

        val items = call.parameters["items"] ?: ""
        call.respond(HttpStatusCode.OK, controller.getAllRecipie(items))

    }
}