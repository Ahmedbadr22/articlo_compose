package com.ahmedbadr.articlo.ui.presentation.screens.topic.view

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.content.res.Resources
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmedbadr.articlo.R
import com.ahmedbadr.articlo.app.extensions.VSpacer
import com.ahmedbadr.articlo.domain.model.data.Topic
import com.ahmedbadr.articlo.ui.theme.ArticloTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectTopicsOfInterestScreen() {
    val resources: Resources = LocalContext.current.resources

    val fakeTopics : List<Topic> = listOf(
        Topic(1, "Sports", "", 1),
    )

    Scaffold {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            Text(
                text = resources.getString(R.string.select_your_topics_of_interest),
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(end = 16.dp)
                    .align(Alignment.Start)
            )
            16.VSpacer()
            Text(
                text = resources.getString(R.string.select_your_topics_of_interest_for_better_recommendations_or_you_can_skip),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .align(Alignment.Start)
            )
            32.VSpacer()
//            LazyVerticalGrid(
//                modifier = Modifier.weight(1f),
//                columns = GridCells.Adaptive(100.dp)
//            ) {
//                items(fakeTopics) { topic ->
//                    ElevatedFilterChip(
//                        modifier = Modifier
//                            .padding(horizontal = 4.dp),
//                        onClick =  {},
//                        label = {
//                            Text(text = topic.name, fontSize = 12.sp)
//                        },
//                        selected = false,
//                        shape = MaterialTheme.shapes.extraLarge
//                    )
//                }
//            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                ElevatedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    onClick = {}
                ) {
                    Text(text = resources.getString(R.string.skip))
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    onClick = {}
                ) {
                    Text(text = resources.getString(R.string.start))
                }
            }
        }
    }
}




@Preview
@Composable
fun SelectTopicsOfInterestScreenLightPreviewEn() {
    ArticloTheme {
        SelectTopicsOfInterestScreen()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SelectTopicsOfInterestScreenDarkPreviewEn() {
    ArticloTheme {
        SelectTopicsOfInterestScreen()
    }
}

@Preview(locale = "ar")
@Composable
fun SelectTopicsOfInterestScreenLightPreviewAr() {
    ArticloTheme {
        SelectTopicsOfInterestScreen()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, locale = "ar")
@Composable
fun SelectTopicsOfInterestScreenDarkPreviewAr() {
    ArticloTheme {
        SelectTopicsOfInterestScreen()
    }
}