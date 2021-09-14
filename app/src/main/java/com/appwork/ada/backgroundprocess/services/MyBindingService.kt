package com.appwork.ada.backgroundprocess.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.util.Log
import java.util.*

class MyBindingService : Service() {
    private var randomNumber: Int = -1
    private var isRunning = false

    companion object {
        const val TAG = "MyForegroundService"
        const val MAX = 100
        const val MIN = 0
    }

    inner class ServiceBinder : Binder() {
        fun getService(): MyBindingService = this@MyBindingService
    }

    private val binder = ServiceBinder()

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        isRunning = true
        Thread {
            Log.e(TAG, "onStartCommand: ${Thread.currentThread().id}")
            startRandomNumberGenerator()
        }.start()
        return START_STICKY
    }

    override fun onBind(intent: Intent?) = binder

    private fun startRandomNumberGenerator() {
        while (isRunning) {
            try {
                Thread.sleep(1000L)
                if (isRunning) {
                    randomNumber = Random().nextInt(MAX) + MIN
                    Log.e(
                        TAG,
                        "startRandomNumberGenerator: Thread : ${Thread.currentThread().id}, \nRandom Number : $randomNumber"
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun stopRandomNumberGenerator() {
        isRunning = false

    }

    public fun getRandomNumber(): Int = randomNumber

    override fun onDestroy() {
        super.onDestroy()
        stopRandomNumberGenerator()
        Log.e(TAG, "onDestroy: ")
    }
}