package ir.arashaltafi

import io.ktor.server.application.*
import ir.arashaltafi.plugins.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    configureRouting()
    configureSerialization()
    configureMonitoring()
}
