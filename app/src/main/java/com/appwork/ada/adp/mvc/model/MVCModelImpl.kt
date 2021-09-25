package com.appwork.ada.adp.mvc.model

import com.appwork.ada.adp.mvc.model.db.UserDb

/**
 * Created by Vivek Kumar belongs to APP WORK  on 24-09-2021.
 */
class MVCModelImpl(
    private val userDb: UserDb
) : MVCModel {
    override fun insertUser(user: UserModel): List<UserModel> {
        return userDb.insertUser(user)
    }

    override fun getAllUsers(): List<UserModel> {
        return userDb.getAllUsers()
    }

    override fun getUserById(id: String): UserModel {
        return userDb.getUserById(id)
    }
}