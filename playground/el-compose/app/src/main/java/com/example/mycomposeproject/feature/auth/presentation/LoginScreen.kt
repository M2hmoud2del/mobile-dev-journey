package com.example.mycomposeproject.feature.auth.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.ElectricBolt
import androidx.compose.material.icons.outlined.LocalOffer
import androidx.compose.material.icons.outlined.LocalShipping
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Security
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycomposeproject.ui.theme.AccentBlue
import com.example.mycomposeproject.ui.theme.BannerBg
import com.example.mycomposeproject.ui.theme.CardBg
import com.example.mycomposeproject.ui.theme.DarkBlueText
import com.example.mycomposeproject.ui.theme.InputBg
import com.example.mycomposeproject.ui.theme.LightBg
import com.example.mycomposeproject.ui.theme.PrimaryOrange
import com.example.mycomposeproject.ui.theme.SubtitleGray

@Composable
fun LoginScreen() {
    var username = rememberTextFieldState("")
    var password = rememberTextFieldState("")
    var passwordVisible by remember { mutableStateOf(false) }
    var rememberDevice by remember { mutableStateOf(true) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = LightBg
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            // App Logo Header
            Box(
                modifier = Modifier
                    .size(92.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Icon(
                        imageVector = Icons.Outlined.LocalOffer,
                        contentDescription = "Logo",
                        tint = PrimaryOrange,
                        modifier = Modifier.size(32.dp)
                    )
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = DarkBlueText,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append("Shop")
                            }

                            withStyle(
                                style = SpanStyle(
                                    color = PrimaryOrange,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append("Mate")
                            }

                        }
                    )
                }

            }

            Spacer(modifier = Modifier.height(12.dp))

            // Title with PRO Tag
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "ShopMate",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkBlueText
                )
                Spacer(modifier = Modifier.width(6.dp))
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = Color(0xFFFCE8E6)
                ) {
                    Text(
                        text = "PRO",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryOrange,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Sign in to access your orders, wishlist, and\nexclusive member discounts.",
                fontSize = 13.sp,
                color = SubtitleGray,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Main Login Card
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = CardBg),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    // Username Field
                    Text(
                        text = "Username or Email",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = DarkBlueText
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    OutlinedTextField(
                        state = username,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        placeholder = {
                            Text(
                                text = "Enter your email",
                                color = SubtitleGray,
                                fontSize = 12.sp
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint = SubtitleGray
                            )
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = InputBg,
                            unfocusedContainerColor = InputBg,
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        ),
                        lineLimits = TextFieldLineLimits.SingleLine
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // Password Field Header
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Password",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = DarkBlueText
                        )
                        Text(
                            text = "Forgot password?",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = AccentBlue,
                            modifier = Modifier.clickable {
                                // forward to Forgot password activity
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))

                    SecureTextField(
                        state = password,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        placeholder = {
                            Text(
                                text = "Enter your password",
                                color = SubtitleGray,
                                fontSize = 12.sp
                                )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null,
                                tint = SubtitleGray
                            )
                        },

                        trailingIcon = {
                            IconButton(
                                onClick = {
                                    passwordVisible = !passwordVisible
                                }
                            ) {
                                Icon(
                                    imageVector = if (passwordVisible)
                                        Icons.Outlined.Visibility
                                    else
                                        Icons.Outlined.VisibilityOff,
                                    contentDescription = if (passwordVisible)
                                        "Hide password"
                                    else
                                        "Show password",
                                    tint = SubtitleGray
                                )
                            }
                        },

                        textObfuscationMode = if (passwordVisible)
                            TextObfuscationMode.Visible
                        else
                            TextObfuscationMode.Hidden,

                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        ),

                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = InputBg,
                            unfocusedContainerColor = InputBg,
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent
                        ),
                    )


                    Spacer(modifier = Modifier.height(12.dp))

                    // Options Row (Remember device & Encrypted badge)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = rememberDevice,
                                onCheckedChange = { rememberDevice = it },
                                colors = CheckboxDefaults.colors(checkedColor = DarkBlueText)
                            )

                            Text(
                                text = "Remember this device",
                                fontSize = 12.sp,
                                color = DarkBlueText
                            )
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Outlined.Security,
                                contentDescription = null,
                                tint = DarkBlueText,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "Encrypted",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = DarkBlueText
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Sign In Button
                    Button(
                        onClick = {
                            // Todo: sign-in logic
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryOrange)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("Sign In", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.width(6.dp))
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Guest Link
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                // TODO: Forward to store activity
                            },
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Browse Store as Guest",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = DarkBlueText
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null,
                            tint = DarkBlueText,
                            modifier = Modifier.size(14.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // OR Divider
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        HorizontalDivider(
                            modifier = Modifier.weight(1f),
                            color = Color.LightGray.copy(alpha = 0.5f)
                        )
                        Text(
                            text = "OR",
                            fontSize = 10.sp,
                            color = SubtitleGray,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                        HorizontalDivider(
                            modifier = Modifier.weight(1f),
                            color = Color.LightGray.copy(alpha = 0.5f)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Sign up
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Don't have an account? ",
                            fontSize = 12.sp,
                            color = SubtitleGray
                        )
                        Text(
                            text = "Sign up",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = DarkBlueText,
                            modifier = Modifier.clickable {
                                // TODO: Forward to Sign-up Activity
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Bottom 3 Feature Cards
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FeatureCard(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Outlined.LocalShipping,
                    title = "Fast Delivery",
                    subtitle = "Track in real-time"
                )
                FeatureCard(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Outlined.LocalOffer,
                    title = "Special Perks",
                    subtitle = "VIP discounts"
                )
                FeatureCard(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Outlined.Lock,
                    title = "Protected",
                    subtitle = "DummyJSON API"
                )
            }

        }
    }
}

@Composable
fun FeatureCard(
    modifier: Modifier = Modifier,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    subtitle: String
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = InputBg)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = DarkBlueText,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = title,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = DarkBlueText,
                textAlign = TextAlign.Center
            )
            Text(
                text = subtitle,
                fontSize = 9.sp,
                color = SubtitleGray,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}