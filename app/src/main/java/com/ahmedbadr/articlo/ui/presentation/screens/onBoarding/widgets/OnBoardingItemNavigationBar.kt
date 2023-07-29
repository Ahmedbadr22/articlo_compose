package com.ahmedbadr.articlo.ui.presentation.screens.onBoarding.widgets

import android.content.res.Resources
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ahmedbadr.articlo.R


@Composable
fun OnBoardingItemNavigationBar(
    resources: Resources,
    inFinalPage: Boolean,
    onSkipClick: () -> Unit,
    onNextClick: () -> Unit,
    onStartClick: () -> Unit,
) {
    Row(
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedButton(
            modifier = Modifier.weight(1F),
            onClick = onSkipClick
        ) {
            Text(text = resources.getString(R.string.skip))
        }
        if (inFinalPage) {
            Button(
                modifier = Modifier.weight(1F),
                onClick = onStartClick
            ) {
                Text(text = resources.getString(R.string.start))
            }
        } else {
            Button(
                modifier = Modifier.weight(1F),
                onClick = onNextClick
            ) {
                Text(text = resources.getString(R.string.next))
            }
        }
    }
}