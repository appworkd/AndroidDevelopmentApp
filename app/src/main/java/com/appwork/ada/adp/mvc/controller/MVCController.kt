package com.appwork.ada.adp.mvc.controller

import com.appwork.ada.adp.mvc.model.MVCModelImpl
import com.appwork.ada.adp.mvc.model.UserModel
import com.appwork.ada.adp.mvc.view.MVCMainActivityView

/**
 * Created by Vivek Kumar belongs to APP WORK  on 24-09-2021.
 */
class MVCController(
    private val mvcModelImpl: MVCModelImpl,
    private val mvcView: MVCMainActivityView
) {
    fun onViewLoaded() {
        mvcView.showAllUsers(mvcModelImpl.getAllUsers())
    }

    fun showAllUser() {
        mvcView.showAllUsers(mvcModelImpl.getAllUsers())
    }

    fun addNewUser(user: UserModel) {
        mvcView.showAllUsers(mvcModelImpl.insertUser(user))
    }

    fun getUser(id: String) {
        mvcView.updateOnSingleUserSelection(mvcModelImpl.getUserById(id))
    }
}