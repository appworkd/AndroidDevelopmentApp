package com.appwork.ada.solid.network

import android.util.Log
import com.appwork.ada.solid.entity.UserEntity

/**
 * Created by Vivek Kumar on 12/09/21.
 */
class ApiInterface {
    companion object {
        const val TAG = "User Api"
    }

    fun saveDataToServer(user: UserEntity) {
        Log.i(TAG, "saveDataToServer: ")
    }
}