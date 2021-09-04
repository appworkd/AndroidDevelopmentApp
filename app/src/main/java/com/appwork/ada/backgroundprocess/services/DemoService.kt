package com.appwork.ada.backgroundprocess.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log


class DemoService : Service() {

    companion object { const val TAG ="DemoService Thread"}

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {


//        Thread{
            Log.i(TAG, "Thread id: ${Thread.currentThread().id}")
            Log.i(TAG, "Thread name: ${Thread.currentThread().name}")

            intent?.let{
                val num =  it.getIntExtra("Number",0)
                for(i in 0..num){
                    Thread.sleep(1000L)
                    Log.i(TAG, "onStartCommand: current value :  $i")
                }
                stopSelf()
            }
//        }.start()


        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: ")
    }
}