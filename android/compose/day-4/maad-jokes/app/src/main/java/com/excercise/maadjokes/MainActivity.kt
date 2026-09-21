package com.excercise.maadjokes

import android.Manifest
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationChannelGroup
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.excercise.maadjokes.ui.theme.MaadJokesTheme
import java.util.concurrent.TimeUnit

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
        scheduleDailyJoke()
    }

    private fun scheduleDailyJoke() {
        val dailyJokeRequest = PeriodicWorkRequestBuilder<JokeWorker>(24, TimeUnit.HOURS)
            .build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "DailyJokeWork",
            ExistingPeriodicWorkPolicy.KEEP,
            dailyJokeRequest
        )
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
    val handler = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()
    ) { isGranted ->

        if(isGranted){
         // show notification
            showNotification(context)
        }else{
            // explain to user and ask him if he want to give this permisson
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


@SuppressLint("MissingPermission")
fun showNotification(context: Context){
    val jokes = arrayOf(
    "An Android Developer had a new child called him Kotlin with \"Koty\" as a nickname (Koty Koty Koo!)",
    "Developers found a Java Developer who was trying to \"drink\" the language.",
    "A hungry Android Developer was trying to make an order from a restaurant, so he ordered a large \"compose\" burger.",
    "An iOS developer wanted to make a \"Swift\" career."
)
    val notification = NotificationCompat
        .Builder(context,"123")
        .setSmallIcon(R.drawable.ic_satisfied)
        .setContentTitle("Maad Joke")
        .setContentText(jokes.random())
        .setAutoCancel(true)
        .build()

    NotificationManagerCompat.from(context).notify(3,notification)
}