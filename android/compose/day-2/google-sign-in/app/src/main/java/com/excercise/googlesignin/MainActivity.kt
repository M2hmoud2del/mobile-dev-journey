package com.excercise.googlesignin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.excercise.googlesignin.ui.theme.GoogleSignInTheme
import com.excercise.googlesignin.ui.theme.RoyalAzure

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GoogleSignInTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {

    var emailField by remember { mutableStateOf("") }

    val brush = remember {
        Brush.linearGradient(listOf(Color.Red, Color.Green, Color.Blue))
    }
    Column(
        modifier = modifier
            .padding(horizontal = 32.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.google_icon),
            contentDescription = "Google Logo",
            modifier = Modifier
                .padding(top = 32.dp)
                .size(40.dp)
        )
        Text(
            text = "Sign in",
            fontSize = 40.sp,
            fontFamily = FontFamily(Font(R.font.google_font)),
            modifier = Modifier
                .padding(top = 32.dp)
        )
        Text(
            text = "Use your Google Account",
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 8.dp),
        )
        OutlinedTextField(
            value = emailField,
            onValueChange = { emailField = it },
            label = { Text("Email or phone") },
            textStyle = TextStyle(brush = brush),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,        // Color when active/focused
                unfocusedBorderColor = Color.Black,    // Color when inactive
                errorBorderColor = Color.Red,          // Color when isError = true
                disabledBorderColor = Color.LightGray,  // Color when enabled = false
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.DarkGray,
            ),
            keyboardOptions = KeyboardOptions( keyboardType = KeyboardType.Email),
            modifier = Modifier
                .widthIn(max = 488.dp)
                .fillMaxWidth()
                .padding(top = 32.dp)
        )
        ClickableText(
            text = "Forgot email?",
            modifier = Modifier
                .padding(top = 8.dp)
        ) {}
        Text(
            text = buildAnnotatedString {
                append("Not your computer? Use Guest mode top sign in privately")
                withLink(
                    LinkAnnotation.Url(
                        "https://support.google.com/chrome/answer/6130773",
                        styles = TextLinkStyles(
                            SpanStyle(
                                color = RoyalAzure,
                                fontWeight = FontWeight.SemiBold,
                                textDecoration = TextDecoration.Underline,
                            )
                        )
                    )
                ) { append(" Learn more about using Guest mode") }
            },
            modifier = Modifier.padding(top = 64.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp)
        ) {
            ClickableText(
                text = "Create Account",
            ) {}

            Button(
                onClick = {},
                colors = ButtonDefaults
                    .buttonColors(containerColor = RoyalAzure)
                ) {
                Text("Next")
            }
        }


    }
}

@Preview(device = "spec:width=411dp,height=891dp", showSystemUi = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}