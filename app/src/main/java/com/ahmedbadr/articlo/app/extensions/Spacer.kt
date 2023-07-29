package com.ahmedbadr.articlo.app.extensions

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Int.VSpacer() {
    Spacer(modifier = Modifier.height(this.dp))
}

@Composable
fun Int.HSpacer() {
    Spacer(modifier = Modifier.width(this.dp))
}