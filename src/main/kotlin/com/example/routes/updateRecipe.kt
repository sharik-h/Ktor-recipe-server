package com.example.routes

import com.example.db.model.Recipie
import com.example.room.RoomController
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.update(controller: RoomController) {
    post("/updateRecipe") {
        call.respond(HttpStatusCode.OK, "called insert")
        val id = call.parameters["id"] ?: return@post
        val name = call.parameters["name"] ?: return@post
        val procedure = call.parameters.getAll("procedure")?.map { it } ?: return@post
        val time = call.parameters["time"] ?: return@post
        val level = call.parameters["levels"] ?: return@post
        val timeType = call.parameters["timeType"] ?: return@post
        val serving = call.parameters["servings"] ?: return@post
        val image = call.parameters["image"] ?: return@post
        val items = call.parameters["items"]
            ?.removeSurrounding("{", "}")
            ?.split(",")
            ?.map {item ->
                item.substringBefore("=") to item.substringAfter("=")
            }

        val recipe = Recipie(
            id = id,
            name = name,
            procedure = procedure,
            time = time,
            items = items!!,
            level = level,
            serving = serving,
            image = image,
            timeType = timeType
        )

        controller.updateRecipe(recipe)

    }
}