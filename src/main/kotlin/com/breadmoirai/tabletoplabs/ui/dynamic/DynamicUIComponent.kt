package com.breadmoirai.tabletoplabs.ui.dynamic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


abstract class DynamicUIComponent(val modifier: Modifier) {

    val children: SnapshotStateList<DynamicUIComponent> = mutableStateListOf<DynamicUIComponent>()

    @Composable
    open fun render() {
        val cs = remember { children }
        for (c in cs) {
            c.render()
        }
    }
}

class RowUIComponent(modifier: Modifier, val horizontal: Arrangement.Horizontal, val vertical: Alignment.Vertical) :
    DynamicUIComponent(modifier) {

    @Composable
    override fun render() {
        Row(modifier, horizontal, vertical) {
            super.render()
        }
    }
}

class ColumnUIComponent(modifier: Modifier, val vertical: Arrangement.Vertical, val horizontal: Alignment.Horizontal) :
    DynamicUIComponent(modifier) {

    @Composable
    override fun render() {
        Column(modifier, vertical, horizontal) {
            super.render()

        }
    }
}

class ButtonUIComponent(
    modifier: Modifier,
    val style: UIComponentStyle,
    val enabled: Boolean = true,
    val contentPadding: PaddingValues
) : DynamicUIComponent(modifier) {

    @Composable
    override fun render() {
        Button(
            {},
            modifier = modifier,
            colors = style.buttonColors(),
            enabled = enabled,
            contentPadding = contentPadding
        ) {
            super.render()
        }
    }
}