package com.maadcoding.ubertrip

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun DataEntry(
    @StringRes text: Int,
    @StringRes fieldLabel: Int,
    modifier: Modifier = Modifier,
    isTimeInput: Boolean = false,
    onClick: (String) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(text = stringResource(text))
        val textFieldState = rememberTextFieldState("0")
        OutlinedTextField(
            state = textFieldState,
            inputTransformation = if (isTimeInput) {
                InputTransformation {
                    replace(
                        0,
                        length,
                        asCharSequence().filter { it.isDigit() }
                    )
                }
            } else {
                null
            },
            label = {
                Text(text = stringResource(fieldLabel))
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = modifier
                .fillMaxWidth()
                .padding(all = 32.dp)
        )

        Button(onClick = { onClick(textFieldState.text.toString()) }) {
            Text(text = stringResource(R.string.next))
        }
    }

}