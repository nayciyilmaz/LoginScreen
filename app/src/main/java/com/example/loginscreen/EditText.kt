package com.example.loginscreen


import androidx.annotation.StringRes
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation

object EditText {

    @Composable
    fun EditTextField(
        value: String,
        onValueChange: (String) -> Unit,
        @StringRes label: Int,
        keyboardOptions: KeyboardOptions,
        visualTransformation: VisualTransformation = VisualTransformation.None,
        @StringRes supportingText: Int? = null
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = stringResource(id = label)) },
            keyboardOptions = keyboardOptions,
            visualTransformation = visualTransformation,
            supportingText=supportingText?.let { { Text(text = stringResource(id = it),
                color=MaterialTheme.colorScheme.tertiary)} }
        )
    }
}