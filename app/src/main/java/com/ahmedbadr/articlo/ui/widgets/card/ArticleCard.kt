package com.ahmedbadr.articlo.ui.widgets.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmedbadr.articlo.R
import com.ahmedbadr.articlo.app.extensions.VSpacer
import com.ahmedbadr.articlo.ui.theme.ArticloTheme

@Composable
fun ArticleVerticalCard(
    modifier: Modifier = Modifier
) {
    val cardWidth = 150.dp
    val bookmarkPainter: Painter = painterResource(id = R.drawable.bookmark)
    Column(
        modifier = modifier
            .width(cardWidth)
    ) {
        Box(
            modifier = Modifier
                .size(cardWidth)
                .fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shapes.medium),
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            FilledTonalIconButton(
                modifier = Modifier
                    .padding(8.dp),
                onClick = {}
            ) {
                Icon(
                    painter = bookmarkPainter,
                    contentDescription = null,
                )
            }
        }
        4.VSpacer()
        Text(
            text = "Learn How to Find Solution for your large data scale using data science",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium
        )
        8.VSpacer()
        CompositionLocalProvider(LocalLayoutDirection.provides(LayoutDirection.Ltr)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.app_logo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Ahmed Badr",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 10.sp
                    ),
                )
                Text(
                    text = "5 days ago",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 8.sp
                    ),
                )

            }
        }
    }
}

@Preview(locale = "en")
@Composable
fun ArticleVerticalCardPreview() {
    ArticloTheme {
        ArticleVerticalCard()
    }
}