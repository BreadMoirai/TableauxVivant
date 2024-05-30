package com.breadmoirai.tabletoplabs.ui.dynamic

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

enum class UIComponentStyle {
    Primary, Secondary, Tertiary, Error;

    @Composable
    fun buttonColors(): ButtonColors {
        return when (this) {
            Primary -> ButtonDefaults.buttonColors(
                MaterialTheme.colorScheme.primary,
                MaterialTheme.colorScheme.onPrimary
            )

            Secondary -> ButtonDefaults.buttonColors(
                MaterialTheme.colorScheme.secondary,
                MaterialTheme.colorScheme.onSecondary
            )

            Tertiary -> ButtonDefaults.buttonColors(
                MaterialTheme.colorScheme.tertiary,
                MaterialTheme.colorScheme.onTertiary
            )

            Error -> ButtonDefaults.buttonColors(
                MaterialTheme.colorScheme.error,
                MaterialTheme.colorScheme.onError
            )
        }
    }
}