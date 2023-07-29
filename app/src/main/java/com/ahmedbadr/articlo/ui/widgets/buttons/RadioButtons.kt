package com.ahmedbadr.articlo.ui.widgets.buttons

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun RadioButtonWithLabel(
    modifier: Modifier = Modifier,
    label: String,
    selected: Boolean,
    onSelected: () -> Unit = {}
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = selected, onClick = onSelected)
        Text(text = label)
    }
}