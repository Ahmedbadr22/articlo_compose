package com.ahmedbadr.articlo.ui.presentation.screens.main.view

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.content.res.Resources
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ahmedbadr.articlo.R
import com.ahmedbadr.articlo.app.extensions.VSpacer
import com.ahmedbadr.articlo.ui.theme.ArticloTheme
import com.ahmedbadr.articlo.ui.widgets.section.HorizontalArticleScrollSection
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
    userFullNameFlow: Flow<String>
) {
    val resources: Resources = LocalContext.current.resources

    val userFullName: String by userFullNameFlow.collectAsStateWithLifecycle(initialValue = "")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = paddingValues.calculateBottomPadding()),
    ) {
        HomeAppBar(
            title = resources.getString(R.string.hello_user, userFullName),
            subTitle = resources.getString(R.string.welcome_back),
            onNotificationIconClick = {},
            onBookmarkIconClick = {}
        )
        16.VSpacer()
        HorizontalArticleScrollSection(
            sectionTitle = resources.getString(R.string.recent_articles),
            onShowAllClick = {

            }
        )
        16.VSpacer()
        HorizontalArticleScrollSection(
            sectionTitle = resources.getString(R.string.your_articles),
            onShowAllClick = {

            }
        )
        16.VSpacer()
        HorizontalArticleScrollSection(
            sectionTitle = resources.getString(R.string.on_your_bookmarks),
            onShowAllClick = {

            }
        )
    }
}


@Composable
@ExperimentalMaterial3Api
fun HomeAppBar(
    title: String,
    subTitle: String = "",
    onNotificationIconClick: () -> Unit,
    onBookmarkIconClick: () -> Unit,
) {
    TopAppBar(
        modifier = Modifier
            .padding(vertical = 8.dp),
        title = {
            Column {
                Text(text = title)
                Text(
                    text = subTitle,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        },
        actions = {
            IconButton(onClick = onNotificationIconClick) {
                Icon(
                    painter = painterResource(id = R.drawable.bell),
                    contentDescription = null
                )
            }
            IconButton(onClick = onBookmarkIconClick) {
                Icon(
                    painter = painterResource(id = R.drawable.bookmark),
                    contentDescription = null
                )
            }
        },
    )
}

val paddingValues = PaddingValues(0.dp)

@Preview(showBackground = true, locale = "en")
@Composable
fun HomeScreenLightPreviewEn() {
    ArticloTheme {
        HomeScreen(
            paddingValues = paddingValues,
            userFullNameFlow = emptyFlow()
        )
    }
}

@Preview(showBackground = true, locale = "ar")
@Composable
fun HomeScreenLightPreviewAr() {
    ArticloTheme {
        HomeScreen(
            paddingValues = paddingValues,
            userFullNameFlow = emptyFlow()
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, locale = "en")
@Composable
fun HomeScreenDarkPreviewEn() {
    ArticloTheme {
        HomeScreen(
            paddingValues = paddingValues,
            userFullNameFlow = emptyFlow()
        )
    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, locale = "ar", showBackground = true)
@Composable
fun HomeScreenDarkPreviewAr() {
    ArticloTheme {
        HomeScreen(
            paddingValues = paddingValues,
            userFullNameFlow = emptyFlow()
        )
    }
}