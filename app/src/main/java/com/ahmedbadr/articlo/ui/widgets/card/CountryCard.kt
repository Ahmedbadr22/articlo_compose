package com.ahmedbadr.articlo.ui.widgets.card

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ahmedbadr.articlo.domain.model.data.Country
import com.ahmedbadr.articlo.ui.theme.ArticloTheme

@Composable
fun CountryCard(
    modifier: Modifier = Modifier,
    country: Country,
    onCountryClick: () -> Unit = {},
    isSelected: Boolean = false
) {
    CompositionLocalProvider(LocalLayoutDirection.provides(LayoutDirection.Ltr)) {
        Card(
            modifier = modifier
                .height(70.dp)
                .padding(bottom = 8.dp)
                .fillMaxWidth()
                .clickable {
                    onCountryClick.invoke()
                },
            shape = MaterialTheme.shapes.small,
            border = if (isSelected) BorderStroke(1.dp, color = MaterialTheme.colorScheme.primary) else null
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(country.flagPath)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(60.dp)
                        .height(40.dp)
                        .clip(MaterialTheme.shapes.extraSmall)
                )
                Text(
                    text = country.abbreviation,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = country.name,
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}


@Preview(locale = "en")
@Composable
fun CountryCardLightPreviewEn() {
    val fakeCountry = Country(1, "Egypt", "EG", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Egypt.svg/2560px-Flag_of_Egypt.svg.png")
    ArticloTheme {
        CountryCard(country = fakeCountry)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CountryCardDarkPreviewEn() {
    val fakeCountry = Country(1, "Egypt", "EG", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Egypt.svg/2560px-Flag_of_Egypt.svg.png")
    ArticloTheme {
        CountryCard(country = fakeCountry)
    }
}

@Preview(locale = "ar")
@Composable
fun CountryCardLightPreviewAr() {
    val fakeCountry = Country(1, "Egypt", "EG", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Egypt.svg/2560px-Flag_of_Egypt.svg.png")
    ArticloTheme {
        CountryCard(country = fakeCountry)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, locale = "ar")
@Composable
fun CountryCardDarkPreviewAr() {
    val fakeCountry = Country(1, "Egypt", "EG", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Egypt.svg/2560px-Flag_of_Egypt.svg.png")
    ArticloTheme {
        CountryCard(country = fakeCountry)
    }
}