package com.appwork.ada.lifecycle.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.appwork.ada.databinding.ActivityLifeCycleBinding

class LifeCycleActivity : AppCompatActivity() {
    companion object {
        const val TAG = "LifeCycleActivity"
        const val EMAIL = "email"
        const val PASS = "pass"
    }

    private val bnLifeCycle by lazy {
        ActivityLifeCycleBinding.inflate(layoutInflater)
    }

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
        bnLifeCycle.btnSave.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
        //Contact List
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
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