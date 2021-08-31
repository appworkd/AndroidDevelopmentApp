package com.appwork.mentorshipprogram.lifecycle.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.appwork.mentorshipprogram.R
import com.appwork.mentorshipprogram.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "Main Activity"
    }

    private val mainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainBinding.root)
        fragmentManager = supportFragmentManager
        mainBinding.btnA.setOnClickListener {
            transWithReplaceAndBackStack(
                FragmentA(),
                R.id.mainContainer,
                "A"
            )
        }
        mainBinding.btnB.setOnClickListener {
            transWithReplaceAndBackStack(
                FragmentB(),
                R.id.mainContainer,
                "B"
            )
        }
        mainBinding.btnC.setOnClickListener {
            transWithReplaceAndBackStack(
                FragmentC(),
                R.id.mainContainer,
                "C"
            )
        }
    }

    /**
     * Simple Add
     */
    private fun transWithAdd(
        fragment: Fragment,
        id: Int,
        tag: String
    ) {
        fragmentManager.beginTransaction()
            .add(id, fragment)
            .commit()
    }

    /**
     * Add With BackStack
     */
    private fun transWithAddAndBackStack(
        fragment: Fragment,
        id: Int,
        tag: String
    ) {
        fragmentManager.beginTransaction()
            .add(id, fragment)
            .addToBackStack(tag)
            .commit()
    }

    /**\
     * Simple Replace
     */
    private fun transWithReplace(
        fragment: Fragment,
        id: Int,
        tag: String
    ) {
        fragmentManager.beginTransaction()
            .replace(id, fragment)
            .commit()
    }

    /**
     * Replace with backstack
     */
    private fun transWithReplaceAndBackStack(
        fragment: Fragment,
        id: Int,
        tag: String
    ) {
        fragmentManager.beginTransaction()
            .replace(id, fragment)
            .addToBackStack(tag)
            .commit()
    }
}