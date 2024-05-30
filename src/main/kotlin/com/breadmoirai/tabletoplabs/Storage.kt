package com.breadmoirai.tabletoplabs

import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf
import kotlinx.serialization.Serializable
import okio.Path.Companion.toPath

object Storage {
    val store: KStore<ObservableDictionary> = storeOf("tabletoplabs.json".toPath())
}

@Serializable
class ObservableDictionary {

}