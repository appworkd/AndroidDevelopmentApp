package com.appwork.ada.lifecycle.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.appwork.ada.R
import com.appwork.ada.databinding.ActivitySecondBinding
import com.appwork.ada.lifecycle.fragments.FirstFragment
import com.appwork.ada.lifecycle.fragments.SecondFragment
import com.appwork.ada.lifecycle.fragments.ThirdFragment

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

          vbSecondActivity.btnAddFirst.setOnClickListener {
              transWithReplaceAndBackStack(FirstFragment(), R.id.hostFragment, "First Fragment")
          }

          vbSecondActivity.btnAddSecond.setOnClickListener {
              transWithReplaceAndBackStack(SecondFragment(), R.id.hostFragment, "Second Fragment")
          }

          vbSecondActivity.button2.setOnClickListener {
              transWithReplaceAndBackStack(ThirdFragment(), R.id.hostFragment, "Second Fragment")
          }

    }

    /**
     * Simple Add
     */
    private fun transWithAdd(fragment: Fragment, id: Int, tag: String) {
        supportFragmentManager.beginTransaction().add(id, fragment, tag).commit()
    }

    /**
     * Add With BackStack
     */
    private fun transWithAddAndBackStack(fragment: Fragment, id: Int, tag: String) {
        supportFragmentManager.beginTransaction().add(id, fragment, tag).addToBackStack(tag).commit()
    }

    /**\
     * Simple Replace
     */
    private fun transWithReplace(fragment: Fragment, id: Int, tag: String) {
        supportFragmentManager.beginTransaction().replace(id, fragment, tag).commit()
    }

    /**
     * Replace with backstack
     */
    private fun transWithReplaceAndBackStack(fragment: Fragment, id: Int, tag: String) {
        supportFragmentManager.beginTransaction().replace(id, fragment, tag).addToBackStack(tag).commit()
    }

}