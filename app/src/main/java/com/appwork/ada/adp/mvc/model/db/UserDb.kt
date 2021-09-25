package com.appwork.ada.adp.mvc.model.db

import com.appwork.ada.adp.mvc.model.UserModel

/**
 * Created by Vivek Kumar belongs to APP WORK  on 24-09-2021.
 */
class UserDb {
    private val list = mutableListOf<UserModel>()
    fun insertUser(user: UserModel): List<UserModel> {
        list.add(user)
        return list
    }

    fun getAllUsers(): List<UserModel> {
        if (list.isNotEmpty()) {
            list.clear()
        }
        for (i in 0 until 5) {
            list.add(UserModel("Name $i", "Num $i"))
        }
        return list
    }

    fun getUserById(id: String = "0"): UserModel {
        return UserModel("Name $id", "Num $id")
    }
}