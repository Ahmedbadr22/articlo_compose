package com.ahmedbadr.articlo.ui.widgets.section

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.ahmedbadr.articlo.R
import com.ahmedbadr.articlo.ui.theme.ArticloTheme


@Composable
fun SectionHeader(
    modifier : Modifier = Modifier,
    title: String,
    onShowAllClick: () -> Unit = {}
) {
    val arrowPainter = painterResource(id = R.drawable.arrow_forward)
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge
        )
        FilledTonalIconButton(
            onClick = onShowAllClick
        ) {
            Icon(
                arrowPainter,
                contentDescription = title,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SectionHeaderLightPreview() {
    ArticloTheme {
        Surface {
            SectionHeader(title = "Your Articles")
        }
    }
}

@Preview(showBackground = false, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SectionHeaderDarkPreview() {
    ArticloTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            SectionHeader(title = "Your Articles")
        }
    }
}