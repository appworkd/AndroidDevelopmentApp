package com.appwork.ada.adp.mvc.model.db

import com.appwork.ada.adp.mvc.model.UserModel

/**
 * Created by Vivek Kumar belongs to APP WORK  on 24-09-2021.
 */
class UserDb {

    fun insertUser(user: UserModel) :Boolean{
       return true
    }

    fun getAllUsers(): List<UserModel> {
        val list = mutableListOf<UserModel>()
        for (i in 0 until 5) {
            list.add(UserModel("Name $i", "Num $i"))
        }
        return list
    }

    fun getUserById(id: String = "0"): UserModel {
        return UserModel("Name $id", "Num $id")
    }
}