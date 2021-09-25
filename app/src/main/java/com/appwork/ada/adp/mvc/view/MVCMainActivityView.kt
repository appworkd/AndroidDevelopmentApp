package com.appwork.ada.adp.mvc.view

import com.appwork.ada.adp.mvc.model.UserModel

/**
 * Created by Vivek Kumar belongs to APP WORK  on 24-09-2021.
 */
interface MVCMainActivityView : MVCView {
    fun bindDataToView()
    fun showAllUsers(usersList: List<UserModel>)
    fun updateOnAddUser(usersList: List<UserModel>)
    fun updateOnSingleUserSelection(user: UserModel)
    fun showError(msg: String)

}