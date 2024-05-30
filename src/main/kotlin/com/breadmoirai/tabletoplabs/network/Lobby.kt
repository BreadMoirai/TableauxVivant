package com.breadmoirai.tabletoplabs.network

import androidx.compose.runtime.mutableStateListOf
import java.util.*

object Lobby {
    val peers = Collections.synchronizedSet<Peer>(LinkedHashSet())
    val commands = mutableStateListOf<Action>()
    val messages = mutableStateListOf<ChatAction>()

}
