package com.appwork.ada.solid.network

import android.util.Log
import com.appwork.ada.solid.entity.UserEntity
import com.appwork.ada.solid.repo.UserDataSource

/**
 * Created by Vivek Kumar on 12/09/21.
 */
class ApiInterface: UserDataSource {
    companion object {
        const val TAG = "User Api"
    }

    override fun saveUser(user: UserEntity) {
        Log.i(TAG, "saveDataToServer: ")
    }
}