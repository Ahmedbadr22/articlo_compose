package com.ahmedbadr.articlo.ui.widgets

import android.content.res.Resources
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.ahmedbadr.articlo.R

@ExperimentalMaterial3Api
@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    value: String,
    labelText: String = "",
    errors: List<Int> = emptyList(),
    keyboardType: KeyboardType = KeyboardType.Text,
    onTextChange: (String) -> Unit,
) {
    val resources: Resources = LocalContext.current.resources
    TextField(
        modifier = modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = onTextChange,
        label = {
            Text(text = labelText)
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = true,
        isError = errors.isNotEmpty(),
        supportingText = {
            if (errors.isNotEmpty()) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    errors.forEach { errorRes ->
                        ErrorRow(text = resources.getString(errorRes))
                    }
                }
            }
        }
    )
}

@Composable
fun ErrorRow(
    text: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(8.dp)
                .background(MaterialTheme.colorScheme.error)
        )
        Text(
            text = text,
            color = MaterialTheme.colorScheme.error
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextFieldWithLeading(
    modifier: Modifier = Modifier,
    value: String,
    labelText: String = "",
    error: String = "",
    @DrawableRes leadingIconRes: Int,
    keyboardType: KeyboardType = KeyboardType.Text,
    onTextChange: (String) -> Unit,
) {
    TextField(
        modifier = modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = onTextChange,
        label = {
            Text(text = labelText)
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = leadingIconRes),
                contentDescription = null
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = true,
        isError = error.isNotEmpty(),
        supportingText = {
            if (error.isNotEmpty()) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = error,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    )
}

@ExperimentalMaterial3Api
@Composable
fun PasswordInputTextField(
    modifier: Modifier = Modifier,
    value: String,
    labelText: String = "",
    errors: List<Int> = emptyList(),
    keyboardType: KeyboardType = KeyboardType.Text,
    onTextChange: (String) -> Unit,
) {
    val resources: Resources = LocalContext.current.resources
    var isHiddenPassword by rememberSaveable { mutableStateOf(true) }

    TextField(
        modifier = modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = onTextChange,
        label = {
            Text(text = labelText)
        },
        visualTransformation = if (isHiddenPassword) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = true,
        trailingIcon = {
            val drawable = if (isHiddenPassword) R.drawable.eye_closed
            else R.drawable.eye

            IconButton(
                onClick = {
                    isHiddenPassword = !isHiddenPassword
                }
            ) {
                Icon(painter = painterResource(id = drawable), contentDescription = null)
            }
        },
        isError = errors.isNotEmpty(),
        supportingText = {
            if (errors.isNotEmpty()) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    errors.forEach { errorRes ->
                        ErrorRow(text = resources.getString(errorRes))
                    }
                }
            }
        }
    )
}