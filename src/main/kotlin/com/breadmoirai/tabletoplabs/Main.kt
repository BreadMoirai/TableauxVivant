package com.breadmoirai.tabletoplabs

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.breadmoirai.tabletoplabs.network.ChatAction
import com.breadmoirai.tabletoplabs.network.Client
import com.breadmoirai.tabletoplabs.network.Server
import com.breadmoirai.tabletoplabs.ui.DynamicRenderer
import com.breadmoirai.tabletoplabs.ui.theme.*
import kotlinx.coroutines.launch
import java.awt.SystemColor.text

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun App() {
    val isDark by remember { mutableStateOf(false) }
    val theme by remember { mutableStateOf(Themes.Fall) }

    val content: @Composable () -> Unit = {
        val scope = rememberCoroutineScope()
        Surface {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                DynamicRenderer.render()

//                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
//                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
//                        Button(onClick = {
//                            isDark = !isDark
//                        }) {
//                            Text(if (isDark) "Dark" else "Light")
//                        }
//                        Button(onClick = {
//                            theme = Themes.entries[(Themes.entries.indexOf(theme) + 1) % Themes.entries.size]
//                        }) {
//                            Text(theme.name)
//                        }
//                    }
//                    var hostLobbyVisible by remember { mutableStateOf(true) }
//                    AnimatedVisibility(hostLobbyVisible) {
//                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
//                            Button(onClick = {
//                                scope.launch {
//                                    hostLobbyVisible = false
//                                    Server.hostLobby()
//                                }
//                            }) {
//                                Text("Host Lobby")
//                            }
//                            Button(onClick = {
//                                scope.launch {
//                                    hostLobbyVisible = false
//                                    Client.connect("127.0.0.1", 8080)
//                                }
//                            }) {
//                                Text("Join Lobby")
//                            }
//                        }
//                    }
//                }
            }

        }
    }

    when (theme) {
        Themes.Fall -> AutumnTheme(content = content, darkTheme = isDark)
        Themes.Winter -> WinterTheme(content = content, darkTheme = isDark)
        Themes.Spring -> SpringTheme(content = content, darkTheme = isDark)
        Themes.Summer -> SummerTheme(content = content, darkTheme = isDark)
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
