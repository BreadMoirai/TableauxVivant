package com.breadmoirai.tabletoplabs.network

import kotlinx.serialization.Polymorphic
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import java.time.Instant


object Actions {
    private val format = Json {
        serializersModule = SerializersModule {
            polymorphic(Action::class) {
                val serializer = ChatAction.serializer()
                subclass(ChatAction::class, serializer)
            }
        }
    }

    fun decode(text: String): Action {
        return format.decodeFromString<Action>(text)
    }

    fun encode(command: Action): String {
        return format.encodeToString(command)
    }
}

@Polymorphic
@Serializable
abstract class Action(val timestamp: Long = Instant.now().toEpochMilli())

@Serializable
@SerialName("ChatAction")
class ChatAction(val author: String, val text: String) : Action()
