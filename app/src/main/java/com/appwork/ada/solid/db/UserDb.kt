package com.appwork.ada.solid.db

import android.util.Log
import com.appwork.ada.solid.entity.UserEntity

/**
 * Created by Vivek Kumar on 12/09/21.
 */
class UserDb {
    companion object {
        const val TAG = "User Db"
    }

    fun saveUserInDatabase(user: UserEntity) {
        Log.i(TAG, "saveUserInDatabase: ")
    }
}