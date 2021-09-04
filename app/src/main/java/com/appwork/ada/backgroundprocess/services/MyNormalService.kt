package com.appwork.ada.backgroundprocess.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.util.*

class MyNormalService : Service() {
    private var count: Int = -1
    private var randomNumber: Int = -1

    companion object {
        const val TAG = "MyNormalService"
        const val MIN = 0
        const val MAX = 100
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(
            TAG,
            "onStartCommand: Thread Id: ${Thread.currentThread().id}"
        )
        Thread {
            intent?.let {
                count = it.getIntExtra("COUNT", 5)
                for (i in 0 until 2000) {
                    Thread.sleep(1000L)
                    randomNumber = Random().nextInt(MAX) + MIN
                    Log.i(
                        TAG,
                        "onStartCommand: Thread Id: ${Thread.currentThread().id}\nRandom Number : $randomNumber"
                    )
                }
                stopSelf()
            }
        }.start()

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder? = null

    override fun onDestroy() {
        Log.i(TAG, "onDestroy: Thread Id: ${Thread.currentThread().id}")
        super.onDestroy()
    }
}