package com.appwork.ada.lifecycle.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.appwork.ada.R
import com.appwork.ada.databinding.ActivitySecondBinding
import com.appwork.ada.lifecycle.fragments.FirstFragment
import com.appwork.ada.lifecycle.fragments.SecondFragment

class SecondActivity : AppCompatActivity() {
    companion object {
        const val TAG = "SecondActivity"
    }

    private val vbSecondActivity by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vbSecondActivity.root)

        attachFragment(
            FirstFragment(), "First Fragment"
        )
        vbSecondActivity.btnAdd.setOnClickListener {
            attachFragment(
                SecondFragment(),
                "Second Fragment"
            )
        }
    }

    private fun attachFragment(
        fragment: Fragment = FirstFragment(),
        tag: String = "First Fragment"
    ) {
        supportFragmentManager.beginTransaction().apply {
            replace(
                R.id.hostFragment,
                fragment,
                tag
            )
            addToBackStack(tag)//
                .commit()
        }
    }
}