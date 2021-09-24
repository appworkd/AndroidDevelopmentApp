package com.appwork.ada.backgroundprocess.thread

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log

/**
 * Created by Vivek Kumar belongs to APP WORK  on 22-09-2021.
 */
class MyLooper : Thread() {
    companion object {
        const val TAG = "MyLooper"

    }

    var handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            Log.i(TAG, "handleMessage: ${Thread.currentThread().id}\n Count : ${msg.obj} ")
        }
    }

    override fun run() {
        super.run()
        Looper.prepare()

        Looper.loop()
    }
}