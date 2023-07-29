package com.ahmedbadr.articlo.ui.presentation.screens.onBoarding.widgets

import android.annotation.SuppressLint
import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmedbadr.articlo.R
import com.ahmedbadr.articlo.ui.presentation.screens.onBoarding.uiState.OnBoardingItem
import com.ahmedbadr.articlo.ui.theme.ArticloTheme

@Composable
fun OnBoardingItemPage(onBoardingItem: OnBoardingItem) {
    val resources: Resources = LocalContext.current.resources

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = onBoardingItem.imageRes),
            contentDescription = null,
            modifier = Modifier
                .weight(1F),
        )
        Text(
            text = resources.getString(onBoardingItem.titleRes),
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center,
            maxLines = 2
        )
        Text(
            text = resources.getString(onBoardingItem.captionRes),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun OnBoardingItemPagePreview() {
    ArticloTheme {
        val fakeOnBoardingItem = OnBoardingItem(R.drawable.read, R.string.on_boarding_0_title, R.string.on_boarding_0_subtitle)
        Scaffold {
            OnBoardingItemPage(fakeOnBoardingItem)
        }
    }
}