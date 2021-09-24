package com.appwork.ada.backgroundprocess.thread

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.appwork.ada.R
import com.appwork.ada.databinding.ActivityMainThreadBinding

class MainThreadActivity : AppCompatActivity() {
    private val vbMain by lazy {
        ActivityMainThreadBinding.inflate(layoutInflater)
    }

    companion object {
        const val TAG = "MainThreadActivity"
    }

    private var isStopped = true
    private var counter = 0
    lateinit var myLooper: MyLooper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vbMain.root)
        myLooper = MyLooper()
        vbMain.btnThreadStart.setOnClickListener {
            genericLooper()
        }

        vbMain.btnThreadStop.setOnClickListener {
            isStopped = false
        }
    }

    fun customLooper() {
        Thread {
            while (isStopped) {
                Log.i(TAG, "customLooper: ${Thread.currentThread().id}")
                Thread.sleep(1000)
                counter++
                Message().apply {
                    this.obj = counter
                    myLooper.handler.sendMessage(this)
                }
            }
        }.start()
    }

    private fun genericLooper() {
         Thread {
             while (isStopped) {
                 Log.i(TAG, "onCreate: ${Thread.currentThread().id}")
                 counter++
//                 vbMain.tvCounter.text = getString(R.string.count, counter)//#1
                 /*Handler(Looper.getMainLooper())//#2
                    .post {
                        vbMain.tvCounter.text = getString(R.string.count, counter)
                    }*/
                /*vbMain.tvCounter.post {//#3
                    vbMain.tvCounter.text = getString(R.string.count, counter)
                }*/
            }
        }.start()
    }
}