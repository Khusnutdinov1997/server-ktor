package com.example.routes

import com.example.repository.HeroRepository
import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.searchHeroes(heroRepository: HeroRepository){
    get("/search/hero"){
        val name = call.request.queryParameters["name"]
        val apiResponse = heroRepository.searchHero(name)
        call.respond(
            message = apiResponse,
            status = HttpStatusCode.OK
        )
    }
}