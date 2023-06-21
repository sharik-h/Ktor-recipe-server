package com.example.routes

import com.example.room.RoomController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getRecipies(controller: RoomController) {
    get("/getRecipes") {
        call.respond(HttpStatusCode.OK, controller.getAllRecipie())
    }
}