package com.appwork.ada.solid.priciples

import com.appwork.ada.solid.db.UserDb
import com.appwork.ada.solid.entity.UserEntity
import com.appwork.ada.solid.network.ApiInterface
import com.appwork.ada.solid.repo.UserRepo

/**
 * Created by Vivek Kumar on 12/09/21.
 * Never depend on Concrete, Only depend on abstraction.
 * High level module should not depend on Low Level Modules.
 * Able to make changes implementation w/o changing the High Level Code
 */
class DependencyInversionClass {
    private var userDb: UserDb = UserDb()
    private var apiInterface = ApiInterface()
    private var userRepo = UserRepo(userDb, apiInterface)

    fun saveUserData() {
        userRepo.saveUser(UserEntity())
    }
}