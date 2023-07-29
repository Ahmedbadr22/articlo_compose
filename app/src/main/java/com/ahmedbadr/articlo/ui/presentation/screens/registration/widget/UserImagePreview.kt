package com.ahmedbadr.articlo.ui.presentation.screens.registration.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ahmedbadr.articlo.R

@Composable
fun UserImagePreview(
    modifier: Modifier = Modifier,
    contentDescription: String,
    userPlaceholderImage: Painter
) {
    Box(
        modifier = modifier
            .size(130.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
        ) {
            Image(
                painter = userPlaceholderImage,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .clickable {  }

            )
        }
        Icon(
            painter = painterResource(id = R.drawable.pen),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .clip(MaterialTheme.shapes.extraSmall)
                .background(color = MaterialTheme.colorScheme.primary)
                .padding(4.dp)

        )
    }
}

