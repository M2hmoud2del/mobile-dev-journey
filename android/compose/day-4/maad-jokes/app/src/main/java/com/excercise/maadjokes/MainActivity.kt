package com.excercise.maadjokes

import android.Manifest
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.test.notifications
import com.excercise.maadjokes.ui.theme.MaadJokesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaadJokesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    JokeButton(modifier = Modifier.padding(innerPadding))
                }
            }
        }

        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            "123",
            "Jokes",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        channel.description = "Showing daily jokes notification"

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(channel)
    }
}

@Composable
fun JokeButton(modifier: Modifier = Modifier) {


    val context = LocalContext.current
    var isDialogShown by remember { mutableStateOf(false) }

    if(isDialogShown)
        PermissionDeniedDialog {
            isDialogShown = false
        }
    val handler = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()
    ) { isGranted ->

        if(isGranted){
         // show notification
            showNotification(context)
        }else{
            isDialogShown = true
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ){

        Button(
            onClick = {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                    handler.launch(Manifest.permission.POST_NOTIFICATIONS)
                }else{
                    //show notification
                    showNotification(context)
                }
            }
        ) { Text("Haha me") }
    }
}

@Preview(showBackground = true)
@Composable
private fun JokeButtonPreview() {
    JokeButton()
}

@Composable
fun PermissionDeniedDialog(modifier: Modifier = Modifier, onClick: () -> Unit) {

    val context = LocalContext.current
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {
            TextButton(
                onClick = {
                    // Intent to system settings
                    val intent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
                    intent.putExtra(Settings.EXTRA_APP_PACKAGE, context.packageName)
                    context.startActivity(intent)
                    onClick()
                }
            ) { Text("Allow") }
        },
        dismissButton = {
            TextButton(
                onClick = onClick
            ) { Text("Cancel") }
        },
        title = { Text("Feature unavailable") },
        text = { Text("Without notification permission, you won’t receive jokes from this app. To stay happy, please enable notifications in Settings.") },
        icon = {
            Icon(
                imageVector = notifications,
                contentDescription = "Notification icon",
            )
        }

    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PermissionDeniedDialogPreview() {
    PermissionDeniedDialog(){}
}

@SuppressLint("MissingPermission")
fun showNotification(context: Context){
    val jokes = arrayOf(
    "An Android Developer had a new child called him Kotlin with \"Koty\" as a nickname (Koty Koty Koo!)",
    "Developers found a Java Developer who was trying to \"drink\" the language.",
    "A hungry Android Developer was trying to make an order from a restaurant, so he ordered a large \"compose\" burger.",
    "An iOS developer wanted to make a \"Swift\" career."
)
    val joke = jokes.random()

    val link = "https://developer.android.com/compose"
    val i = Intent(Intent.ACTION_VIEW)

    val pendingIntent = PendingIntent.getActivity(
        context,
        101,
        i,
        PendingIntent.FLAG_IMMUTABLE
    )

    val notification = NotificationCompat
        .Builder(context,"123")
        .setSmallIcon(R.drawable.ic_satisfied)
        .setContentTitle("Maad Joke")
        .setContentText(joke)
        .setAutoCancel(true)
        .setStyle(
            NotificationCompat.BigTextStyle().bigText(joke)
        )
        .setContentIntent(pendingIntent)
        .build()

    NotificationManagerCompat.from(context).notify(3,notification)
}