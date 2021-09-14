package com.appwork.ada.backgroundprocess.services

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService
import java.util.*

class MyJobIntentService : JobIntentService() {
    companion object {
        const val TAG = "MyJobIntentService"
        const val MIN = 0
        const val MAX = 100
        const val JOB_ID = 101

        fun enqueueWork(
            context: Context,
            intent: Intent
        ) {
            enqueueWork(
                context,
                MyJobIntentService::class.java,
                JOB_ID,
                intent
            )
        }
    }

    private var count: Int = -1
    private var randomNumber: Int = -1


    override fun onHandleWork(intent: Intent) {
        Log.i(
            TAG,
            "Thread Id: ${Thread.currentThread().id}"
        )
        generateRandomNumber(intent)
    }

    override fun onStopCurrentWork(): Boolean {
        Log.i(
            TAG,
            " onStopCurrentWork Thread Id: ${Thread.currentThread().id}"
        )
        return super.onStopCurrentWork()
    }

    private fun generateRandomNumber(intent: Intent) {
        while (true) {
            Thread.sleep(1000L)
            randomNumber = Random().nextInt(MAX) + MIN
            Log.i(
                TAG,
                "Thread Id: ${Thread.currentThread().id}\nRandom Number : $randomNumber"
            )
            stopSelf()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: ")
    }
}