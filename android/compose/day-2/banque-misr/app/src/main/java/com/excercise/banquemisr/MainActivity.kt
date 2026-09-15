package com.excercise.banquemisr

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedSecureTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.LocaleListCompat
import com.excercise.banquemisr.ui.theme.BanqueMisrTheme
import com.excercise.banquemisr.ui.LoginCard
import com.excercise.banquemisr.ui.theme.Red

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BanqueMisrTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    val usernameFieldState = rememberTextFieldState()
    val passwordFieldState = rememberTextFieldState()
    val isLoginEnabled = usernameFieldState.text.isNotBlank() && passwordFieldState.text.isNotBlank()
    val scrollState = rememberScrollState()
    var passwordVisibility by remember { mutableStateOf(false) }
    val icon =
        if (passwordVisibility) painterResource(id = R.drawable.visibility) else painterResource(id = R.drawable.visibility_off)

    val appLocales = AppCompatDelegate.getApplicationLocales()
    val currentLocaleTag = appLocales.get(0)?.language ?: "en"
    Column(
        modifier = modifier
            .padding(top = 92.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
            .fillMaxHeight()
            .verticalScroll(scrollState)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(R.drawable.bm_icon),
                contentDescription = stringResource(R.string.bank_masr_image_cd)
            )
            TextButton(
                onClick = {
                    // Change Language
                    val newLanguageTag = if (currentLocaleTag == "en") "ar" else "en"
                    val localeList = LocaleListCompat.forLanguageTags(newLanguageTag)

                    AppCompatDelegate.setApplicationLocales(localeList)
                }
            ) {
                Text(
                    text = if(currentLocaleTag == "en" ) "العربية" else "EN",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Red,
                )
            }
        }
        OutlinedTextField(
            state = usernameFieldState,
            label = { Text(stringResource(R.string.login_username)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 48.dp)
        )

        OutlinedSecureTextField(
            state = passwordFieldState,
            label = { Text(stringResource(R.string.login_password)) },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(
                        painter = icon,
                        contentDescription = stringResource(R.string.login_password_hide_icon)
                    )
                }
            },
            textObfuscationMode = if (passwordVisibility) TextObfuscationMode.Visible else TextObfuscationMode.Hidden,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        )

        Text(
            text = stringResource(R.string.login_forgot_password_or_username),
            textDecoration = TextDecoration.Underline,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 24.dp)
        )

        Button(
            onClick = {
                // call login logic
            },
            enabled = isLoginEnabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Red,
                disabledContainerColor = Red.copy(alpha = .3f),
                disabledContentColor = Color.White
            ),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 48.dp)
                .height(64.dp)
        ) {
            Text(
                text = stringResource(R.string.login_btn),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
                )
        }

        Text(
            text = buildAnnotatedString {
                append(stringResource(R.string.login_help_1) + " ")
                withLink(
                    LinkAnnotation.Url(
                        url = stringResource(R.string.login_help_url),
                        TextLinkStyles(
                            style = SpanStyle(
                                color = Red,
                                fontWeight = FontWeight.SemiBold,
                                textDecoration = TextDecoration.Underline
                            )
                        )
                    )
                ){
                    append(stringResource(R.string.login_help_2))
                }
            },
            fontSize = 16.sp
            ,
            modifier = Modifier
                .padding(top = 24.dp)
        )


        HorizontalDivider(modifier = Modifier.padding(top = 56.dp, bottom = 48.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            LoginCard(stringResource(R.string.login_card_our_products),R.drawable.our_products, modifier = Modifier.weight(1f, fill = false)) { }
            LoginCard(stringResource(R.string.login_card_exchange_rate),R.drawable.exchange_rate, modifier = Modifier.weight(1f, fill = false)) { }
            LoginCard(stringResource(R.string.login_card_security_tips),R.drawable.security_tips, modifier = Modifier.weight(1f, fill = false)) { }
            LoginCard(stringResource(R.string.login_card_nearest_branch),R.drawable.nearest_branch_or_atm, modifier = Modifier.weight(1f, fill = false)) { }
        }
    }
}

@Preview(device = "spec:width=411dp,height=891dp", showSystemUi = true)
@Composable
private fun LoginScreenPreview() {
    BanqueMisrTheme {
        LoginScreen()
    }
}