package com.example.plagins

import io.ktor.http.HttpHeaders
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.defaultheaders.DefaultHeaders
import kotlin.time.Duration.Companion.days

fun Application.configureDefaultHeader(){
    install(plugin = DefaultHeaders){
        val oneYearInSeconds = 365.days.inWholeSeconds
        header(name = HttpHeaders.CacheControl, value = "Public, max age $oneYearInSeconds")
    }
}