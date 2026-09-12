package com.excercise.googlesignin

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.excercise.googlesignin.ui.theme.RoyalAzure

@Composable
fun ClickableText(text: String,modifier: Modifier = Modifier,
                  onMyClick: () -> Unit
) {

    Text(
        text = text,
        color = RoyalAzure,
        fontWeight = FontWeight.SemiBold,
        modifier = modifier
            .clickable(onClick = onMyClick)
    )

}