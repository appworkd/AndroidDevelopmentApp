package com.appwork.ada.solid.repo

import com.appwork.ada.solid.db.UserDb
import com.appwork.ada.solid.entity.UserEntity
import com.appwork.ada.solid.network.ApiInterface

/**
 * Created by Vivek Kumar on 12/09/21.
 */
class UserRepo(
    private val userDb: UserDb,
    private val api: ApiInterface
) : UserDataSource {

    /*fun saveToLocal(user: UserEntity) = userDb.saveUserInDatabase(user)

    fun callApi(user: UserEntity) = api.saveDataToServer(user)*/

    override fun saveUser(user: UserEntity) {//high level code

    }
}