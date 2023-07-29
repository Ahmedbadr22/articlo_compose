package com.ahmedbadr.articlo.ui.widgets.buttons

import android.content.res.Resources
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.ahmedbadr.articlo.R

@Composable
fun BackButton(
    onNavigateBack: () -> Unit = {},
) {
    val resources: Resources = LocalContext.current.resources
    val iconPainter : Painter = painterResource(id = R.drawable.arrow_back)

    IconButton(
        onClick = onNavigateBack
    ) {
        Icon(
            iconPainter,
            contentDescription = resources.getString(R.string.arrow_back)
        )
    }
}