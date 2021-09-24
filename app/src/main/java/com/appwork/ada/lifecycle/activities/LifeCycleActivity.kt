package com.appwork.ada.lifecycle.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import com.appwork.ada.backgroundprocess.services.MyJobIntentService
import com.appwork.ada.backgroundprocess.services.work.MyWorker
import com.appwork.ada.backgroundprocess.services.work.MyWorker1
import com.appwork.ada.backgroundprocess.services.work.MyWorker2
import com.appwork.ada.databinding.ActivityLifeCycleBinding
import java.util.*
import java.util.concurrent.TimeUnit

class LifeCycleActivity : AppCompatActivity() {

    companion object {
        const val TAG = "FirstActivity Thread"
        const val EMAIL = "email"
        const val PASS = "pass"
        const val INTERVAL = 15
    }

    private val serviceIntent by lazy {
        Intent(this, MyJobIntentService::class.java)
    }
    private val bnLifeCycle by lazy {
        ActivityLifeCycleBinding.inflate(layoutInflater)
    }
    private val workManager by lazy {
        WorkManager.getInstance(applicationContext)
    }

    private lateinit var workReq: OneTimeWorkRequest
   private lateinit var workReq1: OneTimeWorkRequest
     private lateinit var workReq2: OneTimeWorkRequest
     private lateinit var workReq3: OneTimeWorkRequest
     private lateinit var workReq4: OneTimeWorkRequest
    private lateinit var periodicWork: PeriodicWorkRequest


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bnLifeCycle.root)

        Log.d(TAG, "onCreate: ")

        if (savedInstanceState == null) {
            Log.d(TAG, "onCreate: Bundle is null")
        } else {
            Log.d(TAG, "onCreate: Bundle is not null")
            bnLifeCycle.edtEmail.setText(savedInstanceState.getString(EMAIL))
            bnLifeCycle.edtPass.setText(savedInstanceState.getString(PASS))
        }

        /**
        Data we are passing to Worker
         */
        val data = Data.Builder().apply {
            putInt("REPEAT", 50)
        }.build()

        /**
         * Constraints we are passing to Worker
         */
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED) // network type required for your work to run
            .setRequiresBatteryNotLow(true) //true = work will not run when device battery is low
            .setRequiresCharging(true) // true = work will only run when the device is charging
            .setRequiresDeviceIdle(true) // true = requires the user’s device to be idle before the work will run
            .setRequiresStorageNotLow(true) // true =  if the user’s storage space on the device is too low your work will not run
            .build()

        periodicWork = PeriodicWorkRequestBuilder<MyWorker>(
            5,
            TimeUnit.MINUTES
        ).build()

      workReq = OneTimeWorkRequestBuilder<MyWorker>()
            .setInputData(data) // assigning data to work request
            .addTag("Worker") // setting tag
            .build()

         workReq1 = OneTimeWorkRequestBuilder<MyWorker1>()
             .setConstraints(constraints)
             .addTag("Worker1")
             .build()

         workReq2 = OneTimeWorkRequestBuilder<MyWorker2>()
             .setConstraints(constraints)
             .addTag("Worker2")
             .build()

        workReq3 = OneTimeWorkRequestBuilder<MyWorker2>()
             .setConstraints(constraints)
             .addTag("Worker3")
             .build()

        workReq4 = OneTimeWorkRequestBuilder<MyWorker2>()
             .setConstraints(constraints)
             .addTag("Worker4")
             .build()

        bnLifeCycle.btnSave.setOnClickListener {
           // workManager.enqueue(workReq)

            workManager.beginWith(workReq)
                .then(workReq1)
                .then(workReq2)
                .enqueue()

        }

        bnLifeCycle.btnStop.setOnClickListener {
            workManager.cancelWorkById(periodicWork.id)
            workManager.cancelAllWorkByTag("Worker2")
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart:")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()

        Log.d(TAG, "onPause:")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(EMAIL, bnLifeCycle.edtEmail.text.toString())
        outState.putString(PASS, bnLifeCycle.edtPass.text.toString())
        Log.d(TAG, "onSaveInstanceState: ")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState: ")
    }


}