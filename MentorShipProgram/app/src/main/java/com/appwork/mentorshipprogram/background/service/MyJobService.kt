package com.appwork.mentorshipprogram.background.service

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log
import java.util.*

class MyJobService : JobService() {
    companion object {
        const val TAG = "MyJobService"
        const val MIN = 0
        const val MAX = 100
    }

    private var randomNumber: Int = -1
    private var isRunning=false

    override fun onStartJob(params: JobParameters?): Boolean {
        Log.e(TAG, "onStartJob: Thread Id: ${Thread.currentThread().id}")
        isRunning =true
        Thread {
            generateRandomNumber()
        }.start()
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.e(TAG, "onStopJob: Thread Id: ${Thread.currentThread().id}")
        return false
    }

    private fun generateRandomNumber() {
        while (isRunning) {
            Thread.sleep(1000L)
            randomNumber = Random().nextInt(MAX) + MIN
            Log.e(
                TAG,
                "Thread Id: ${Thread.currentThread().id}\nRandom Number : $randomNumber"
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning=false
        Log.e(
            TAG,
            "Thread Id: ${Thread.currentThread().id}\nRandom Number : $randomNumber"
        )
    }
}