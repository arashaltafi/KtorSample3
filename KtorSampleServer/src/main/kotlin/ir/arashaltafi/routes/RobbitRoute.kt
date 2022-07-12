package ir.arashaltafi.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import ir.arashaltafi.data.model.Rabbit


private const val BASE_URL = "http://192.168.1.101:8010"

private val rabbits = listOf(
    Rabbit("Carl", "A cute brown rabbit", "$BASE_URL/rabbits/rabbit1.jpg"),
    Rabbit("Emma", "Emma likes to eat apples", "$BASE_URL/rabbits/rabbit2.jpg"),
    Rabbit("Florian", "Florian is always hungry", "$BASE_URL/rabbits/rabbit3.jpg"),
    Rabbit("Federico", "Federico likes to climb mountains", "$BASE_URL/rabbits/rabbit4.jpg"),
    Rabbit("Gina", "Gina is a true beauty", "$BASE_URL/rabbits/rabbit5.jpg"),
)

fun Route.randomRabbit() {
    get("/randomRabbit") {
        call.respond(
            HttpStatusCode.OK,
            rabbits.random()
        )
    }
}