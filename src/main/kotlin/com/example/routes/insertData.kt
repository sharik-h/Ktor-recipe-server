package com.example.routes

import com.example.db.model.Recipie
import com.example.room.RoomController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.inserData(controller: RoomController) {
    get("/insert") {
        call.respond(HttpStatusCode.OK, "called insert")
        val name = call.parameters["name"] ?: return@get
        val items = call.parameters["items"] ?: return@get
        val procedure = call.parameters["procedure"] ?: return@get
        val time = call.parameters["time"] ?: return@get

        val recipie = Recipie(
            name = name,
            procedure = procedure,
            time = time,
            items = items
        )

        controller.addRecipie(recipie)

    }

}