package com.example.routes

import com.example.db.model.Recipie
import com.example.room.RoomController
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Route.update(controller: RoomController) {
    get("/updateRecipe") {
        val id = call.parameters["id"] ?: return@get
        val name = call.parameters["name"] ?: return@get
        val time = call.parameters["time"] ?: return@get
        val procedure = call.parameters["procedure"] ?: return@get
        val items = call.parameters["items"] ?: return@get

        val recipie = Recipie(
            name = name,
            time = time,
            items =  items,
            procedure = procedure,
            id = id
        )

        controller.updateRecipe(recipie)

    }
}