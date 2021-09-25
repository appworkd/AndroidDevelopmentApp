package com.appwork.ada.adp.mvc.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainMVCActivity : AppCompatActivity() {
    private val mvcViewActivityImpl by lazy {
        MVCViewActivityImpl(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mvcViewActivityImpl.getRootView())
        mvcViewActivityImpl.initView()
    }

    override fun onResume() {
        super.onResume()
        mvcViewActivityImpl.bindDataToView()
    }
}