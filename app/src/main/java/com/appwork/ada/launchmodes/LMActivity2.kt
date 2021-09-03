package com.appwork.ada.launchmodes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.appwork.ada.R
import com.appwork.ada.databinding.ActivityLmactivity1Binding
import com.appwork.ada.databinding.ActivityLmactivity2Binding

class LMActivity2 : AppCompatActivity() {

    private val vbA by lazy {
        ActivityLmactivity2Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vbA.root)

        vbA.btnA.setOnClickListener {
            startActivity(Intent(this,LMActivity1::class.java))
        }

        vbA.btnB.setOnClickListener {
            startActivity(Intent(this,LMActivity2::class.java))
        }
        vbA.btnC.setOnClickListener {
            startActivity(Intent(this,LMActivity3::class.java))
        }
        vbA.btnD.setOnClickListener {
            startActivity(Intent(this,LMActivity4::class.java))
        }
    }


}