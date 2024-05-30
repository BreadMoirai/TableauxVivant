package com.breadmoirai.tabletoplabs.network

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.websocket.*
import io.ktor.http.*
import io.ktor.websocket.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
object Client {

    private val client: HttpClient = HttpClient(CIO) {
        install(WebSockets) {
            pingInterval = 20_000
        }
    }
    val isConnected: Boolean
        get() = session.value != null
    private val _incoming: MutableSharedFlow<Action> = MutableSharedFlow()
    val incoming: SharedFlow<Action> = _incoming.asSharedFlow()
    val outgoing: Channel<Action> = Channel()
    private var session = MutableStateFlow<WebSocketSession?>(null)

    init {
        GlobalScope.launch {
            session.collectLatest { session ->
                println("Collecting incoming commands for session: $session")
                if (session == null) return@collectLatest
                while (isActive) {
                    val msg = session.incoming.receive() as? Frame.Text ?: continue
                    this@Client._incoming.emit(Actions.decode(msg.readText()))
                }
            }
        }
    }

    fun connect(host: String, port: Int) {
        GlobalScope.launch {
            println("closing?")
            session.value?.close()
            println("closed!")
            client.webSocket(HttpMethod.Get, host, port, "/tabletoplabs") {
                session.emit(this)
                while (isActive) {
                    val msg = this@Client.outgoing.receive()
                    outgoing.send(Frame.Text(Actions.encode(msg)))
                }
            }
        }
    }

}