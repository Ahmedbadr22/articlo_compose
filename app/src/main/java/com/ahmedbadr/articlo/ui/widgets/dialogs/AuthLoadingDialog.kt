package com.ahmedbadr.articlo.ui.widgets.dialogs

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.ahmedbadr.articlo.R
import com.ahmedbadr.articlo.ui.theme.ArticloTheme

enum class LoadingDialogType {
    LOGIN,
    REGISTRATION,
}

@Composable
@ExperimentalMaterial3Api
fun LoadingDialog(
    loadingDialogType: LoadingDialogType = LoadingDialogType.LOGIN,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
) {
    val resources: Resources = LocalContext.current.resources
    val imagePainter = when(loadingDialogType) {
        LoadingDialogType.LOGIN -> painterResource(id = R.drawable.login)
        LoadingDialogType.REGISTRATION -> painterResource(id = R.drawable.registration)
    }

    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .height(300.dp)
                .width(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = imagePainter,
                contentDescription = null,
            )
            Text(
                text = resources.getString(R.string.loading),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = resources.getString(R.string.please_wait_while_your_process_finish_it_may_take_seconds),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )
            CircularProgressIndicator()
        }
    }
}


@Composable
@ExperimentalMaterial3Api
fun OpenLoadingDialog(loadingDialogType: LoadingDialogType = LoadingDialogType.LOGIN) {
    Dialog(onDismissRequest = {}) {
        LoadingDialog(loadingDialogType = loadingDialogType)
    }
}

@Preview
@Composable
@ExperimentalMaterial3Api
fun AuthLoadingDialogLightPreview() {
    ArticloTheme {
        Box(
            contentAlignment = Alignment.Center
        ) {
            LoadingDialog(
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@ExperimentalMaterial3Api
fun AuthLoadingDialogDarkPreview() {
    ArticloTheme {
        Box(
            contentAlignment = Alignment.Center
        ) {
            LoadingDialog(
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}