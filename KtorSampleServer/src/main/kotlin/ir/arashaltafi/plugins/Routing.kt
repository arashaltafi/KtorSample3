package ir.arashaltafi.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import ir.arashaltafi.routes.randomRabbit

fun Application.configureRouting() {


    routing {
        randomRabbit()
        // Static plugin. Try to access `/static/index.html`
        static {
            resources("static")
        }
    }
}
