package com.breadmoirai.tabletoplabs.network

import io.ktor.websocket.*
import java.util.concurrent.atomic.AtomicInteger

class Peer(val session: DefaultWebSocketSession) {
    companion object {
        val lastId = AtomicInteger(0)
    }
    val name = "user${lastId.getAndIncrement()}"
}