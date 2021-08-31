package com.appwork.mentorshipprogram.background

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.appwork.mentorshipprogram.background.service.MyBindingService
import com.appwork.mentorshipprogram.background.service.MyJobIntentService
import com.appwork.mentorshipprogram.background.service.MyJobService
import com.appwork.mentorshipprogram.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val TAG = "MyJobService Act"
        const val JOB_ID = 1001
    }

    private val js by lazy {
        getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
    }

    private lateinit var vbSecond: ActivitySecondBinding
    private lateinit var serviceIntent: Intent
    private var isBound = false
    private lateinit var myService: MyBindingService
    private val serviceConnection by lazy {
        object : ServiceConnection {
            override fun onServiceConnected(
                name: ComponentName?,
                service: IBinder?
            ) {
                val binder = service as MyBindingService.ServiceBinder
                myService = binder.getService()
                isBound = true
            }

            override fun onServiceDisconnected(name: ComponentName?) {
                isBound = false
            }
        }
    }

    private fun startJobIntentService() {
        MyJobIntentService.enqueueWork(this, serviceIntent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vbSecond = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(vbSecond.root)
        serviceIntent =
            Intent(applicationContext, MyJobIntentService::class.java).putExtra("COUNT", 10)
        vbSecond.buttonStart.setOnClickListener(this)
        vbSecond.buttonStop.setOnClickListener(this)
        vbSecond.buttonBind.setOnClickListener(this)
        vbSecond.buttonUnbind.setOnClickListener(this)
        vbSecond.buttonGet.setOnClickListener(this)
    }

    private fun startMyService() {
        Log.e(TAG, "startMyService: Thread ${Thread.currentThread().id}")
        startJobScheduler()
//        startJobIntentService()
//        startService(serviceIntent)
    }

    private fun startJobScheduler() {
        val componentName = ComponentName(this, MyJobService::class.java)
        val jobInfo = JobInfo.Builder(JOB_ID, componentName)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_NONE)
            .setPeriodic(15 * 60 * 1000)
            .setRequiresCharging(true)
            .setPersisted(true)
            .build()
        if (js.schedule(jobInfo) == JobScheduler.RESULT_SUCCESS) {
            Log.e(
                TAG,
                "startJobScheduler RESULT_SUCCESS : Thread Id : ${Thread.currentThread().id}",
            )
        } else {
            Log.e(TAG, "startJobScheduler RESULT_FAILED: Thread Id : ${Thread.currentThread().id}")
        }
    }

    private fun stopJobScheduler() {
        js.cancel(JOB_ID)
    }

    private fun stopMyService() {
//        stopService(serviceIntent)
        stopJobScheduler()
    }

    private fun bindMyService() {
        bindService(
            serviceIntent,
            serviceConnection,
            Context.BIND_AUTO_CREATE
        )
    }

    private fun unbindMyService() {
        if (isBound) {
            unbindService(serviceConnection)
            isBound = false
        }
    }

    private fun getNumber() {
        if (isBound) {
            vbSecond.textView.text = myService.getRandomNumber().toString()
        } else {
            vbSecond.textView.text = "Service Unbound"
        }

    }

    override fun onClick(v: View?) {
        v?.let {
            when (v) {
                vbSecond.buttonStart -> {
                    startMyService()
                }
                vbSecond.buttonStop -> {
                    stopMyService()
                }
                vbSecond.buttonBind -> {
                    bindMyService()
                }
                vbSecond.buttonUnbind -> {
                    unbindMyService()
                }
                vbSecond.buttonGet -> {
                    getNumber()
                }
            }
        }
    }
}