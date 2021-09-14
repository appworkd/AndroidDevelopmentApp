package com.appwork.ada.backgroundprocess.services.work

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.hasKeyWithValueOfType
import java.util.*

/**
 * Created by Vivek Kumar belongs to APP WORK  on 07-09-2021.
 */
class MyWorker(
    private val context: Context,
    private val workPara: WorkerParameters
) : Worker(context, workPara) {

    companion object {
        const val TAG = "MyWorker"
        const val MIN = 0
        const val MAX = 100
    }

    private var randomNumber: Int = 0
    private var isOn = true

    override fun doWork(): Result {
        startGenerating()
        return Result.success()
    }

    private fun startGenerating() {
        var i = 0
        val extraData = workPara.inputData
        var re = 5
        if (extraData.hasKeyWithValueOfType<Int>("REPEAT")) {
            re = extraData.getInt("REPEAT", 5)
        }
        while (i < 5 && !isStopped) {
//        while (i < 20) {
            try {
                Thread.sleep(1000L)
                randomNumber = Random().nextInt(MAX) + MIN
                Log.i(
                    TAG,
                    "startGenerating: $randomNumber\nThread ID: ${Thread.currentThread().id}"
                )
                i++
            } catch (e: Exception) {
                Log.i(TAG, "startGenerating: Exception ${e.message}")
            }
        }
    }

    override fun onStopped() {
        super.onStopped()
        Log.i(TAG, "onStopped: ")
    }
}