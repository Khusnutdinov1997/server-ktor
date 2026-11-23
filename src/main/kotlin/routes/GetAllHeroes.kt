package com.example.routes

import com.example.models.ApiResponse
import com.example.repository.HeroRepository
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getAllHeroes(heroRepository: HeroRepository) {
    get("/heroes/all") {
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            require(page in 1 .. 5 )
            val apiResponse = heroRepository.getAllHeroes(page)
            call.respond(
                message = apiResponse,
                status = HttpStatusCode.OK
            )
        } catch (e: NumberFormatException) {
            call.respond(
                message = ApiResponse(
                    success = false,
                    message = "Only numbers allowed"
                ),
                status = HttpStatusCode.BadRequest
            )
        } catch (e: IllegalArgumentException) {
            call.respond(
                message = ApiResponse(
                    success = false,
                    message = "Not found"
                ),
                status = HttpStatusCode.NotFound
            )
        }
    }
}