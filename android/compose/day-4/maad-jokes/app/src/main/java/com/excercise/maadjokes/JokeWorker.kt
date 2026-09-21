package com.excercise.maadjokes

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class JokeWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    override fun doWork(): Result {
        // Show the notification with a random joke
        showNotification(applicationContext)
        
        return Result.success()
    }
}
