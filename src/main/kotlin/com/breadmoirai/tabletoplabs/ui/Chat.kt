package com.breadmoirai.tabletoplabs.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.breadmoirai.tabletoplabs.network.Lobby
import kotlinx.coroutines.delay
import java.time.Instant
import kotlin.time.Duration.Companion.seconds

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChatBox(): Unit {
    Box(modifier = Modifier.padding(5.dp).fillMaxSize()) {
        Column(modifier = Modifier.padding(5.dp)) {
            Surface(
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.fillMaxWidth().height(1.dp),
                color = Color.Gray.copy(alpha = 0.5f)
            ) {
//                LazyColumn(reverseLayout = true, modifier = Modifier.fillMaxSize()) {
//                    items(Lobby.messages, key = { msg -> msg.hashCode() }) { msg ->
//                        var msgVisible by remember { msg.visibleState }
//                        AnimatedVisibility(msgVisible) {
//                            Text(
//                                modifier = Modifier.animateItemPlacement(),
//                                textAlign = TextAlign.Left,
//                                text = "${msg.from}: ${msg.msg}"
//                            )
//                        }
//                        if (msg.time.plusSeconds(5).isAfter(Instant.now())) {
//                            LaunchedEffect(Unit) {
//                                msgVisible = true
//                                delay(5.seconds)
//                                msgVisible = false
//                            }
//                        }
//                    }
//                }
            }
        }
    }
}