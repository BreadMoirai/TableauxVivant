package com.breadmoirai.tabletoplabs.network

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.Duration
import java.time.Instant

@OptIn(DelicateCoroutinesApi::class)
object Server {

    private val server = embeddedServer(Netty, port = 8080) { module() }

    fun hostLobby() {
        GlobalScope.launch {
            server.start(false)
        }
    }

    fun closeLobby() {
        GlobalScope.launch {
            server.stop()
        }
    }


    private fun Application.module() {
        install(WebSockets) {
            pingPeriod = Duration.ofSeconds(15)
            timeout = Duration.ofSeconds(15)
            maxFrameSize = Long.MAX_VALUE
            masking = false
        }
        routing {
            webSocket("/tabletoplabs") {
                println("Adding user!")
                val thisConnection = Peer(this)
                Lobby.peers += thisConnection
                try {
                    for (frame in incoming) {
                        frame as? Frame.Text ?: continue
                        val receivedText = frame.readText()
                        println(receivedText)
                        Lobby.messages.add(0, ChatAction(thisConnection.name, receivedText))
                    }
                } catch (e: Exception) {
                    println(e.localizedMessage)
                } finally {
                    println("Removing $thisConnection!")
                    Lobby.peers -= thisConnection
                }
            }
        }
    }
}