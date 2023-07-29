package com.ahmedbadr.articlo.ui.presentation.screens.selectCountry.view

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.content.res.Resources
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmedbadr.articlo.R
import com.ahmedbadr.articlo.app.extensions.VSpacer
import com.ahmedbadr.articlo.domain.model.data.Country
import com.ahmedbadr.articlo.ui.theme.ArticloTheme
import com.ahmedbadr.articlo.ui.widgets.InputTextFieldWithLeading
import com.ahmedbadr.articlo.ui.widgets.card.CountryCard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectYourCountryScreen(
    onNavigateToNextScreen: () -> Unit = {},
    countriesFlow: StateFlow<List<Country>>
) {
    val resource: Resources = LocalContext.current.resources
    var selectedCountry: Country? by rememberSaveable { mutableStateOf(null) }
    var searchValue: String by rememberSaveable { mutableStateOf("") }
    val isVisibleButton: Boolean = selectedCountry != null

    val countries: List<Country> by countriesFlow.collectAsState()

    Scaffold {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            Text(
                text = resource.getString(R.string.which_country_are_you_from),
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(end = 16.dp)
                    .align(Alignment.Start)
            )
            16.VSpacer()
            Text(
                text = resource.getString(R.string.please_select_country_of_origin),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            32.VSpacer()
            InputTextFieldWithLeading(
                value = searchValue,
                leadingIconRes = R.drawable.search_linear,
                onTextChange = { value ->
                    searchValue = value
                },
                labelText = resource.getString(R.string.search)
            )
            16.VSpacer()
            LazyColumn(
                modifier = Modifier
                    .weight(1.0f),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                items(countries) { country ->
                    CountryCard(
                        country = country,
                        onCountryClick = {
                            selectedCountry = country
                        },
                        isSelected = country.id == selectedCountry?.id
                    )
                }
            }
            8.VSpacer()
            AnimatedVisibility(visible = isVisibleButton) {
                OutlinedButton(
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth(),
                    onClick = onNavigateToNextScreen,
                ) {
                    Text(text = resource.getString(R.string.next))
                }
            }
        }
    }
}


@Preview
@Composable
fun SelectYourCountryScreenLightPreviewEn() {
    ArticloTheme {
        SelectYourCountryScreen(
            countriesFlow = MutableStateFlow(emptyList())
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SelectYourCountryScreenDarkPreviewEn() {
    ArticloTheme {
        SelectYourCountryScreen(
            countriesFlow = MutableStateFlow(emptyList())
        )
    }
}


@Preview(locale = "ar")
@Composable
fun SelectYourCountryScreenLightPreviewAr() {
    ArticloTheme {
        SelectYourCountryScreen(
            countriesFlow = MutableStateFlow(emptyList())
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, locale = "ar")
@Composable
fun SelectYourCountryScreenDarkPreviewAr() {
    ArticloTheme {
        SelectYourCountryScreen(
            countriesFlow = MutableStateFlow(emptyList())
        )
    }
}