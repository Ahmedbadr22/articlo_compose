package com.ahmedbadr.articlo.ui.widgets

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmedbadr.articlo.R
import com.ahmedbadr.articlo.ui.theme.ArticloTheme


@Composable
fun AppLogo(
    modifier: Modifier = Modifier
) {
    val appLogo = painterResource(id = R.drawable.app_logo)
    val resources: Resources = LocalContext.current.resources
    Image(
        painter = appLogo,
        contentDescription = resources.getString(R.string.app_logo),
        modifier = modifier
            .height(100.dp)
            .width(100.dp)
    )
}

@Preview
@Composable
fun AppLogoPreview() {
    ArticloTheme {
        AppLogo()
    }
}