package com.appwork.ada.solid.db

import android.util.Log
import com.appwork.ada.solid.entity.UserEntity
import com.appwork.ada.solid.repo.UserDataSource
import javax.sql.DataSource

/**
 * Created by Vivek Kumar on 12/09/21.
 */
class UserDb :UserDataSource{
    companion object {
        const val TAG = "User Db"
    }
    override fun saveUser(user: UserEntity) {
        Log.i(TAG, "saveUserInDatabase: ")
    }
}