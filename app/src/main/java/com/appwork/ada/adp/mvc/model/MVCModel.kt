package com.appwork.ada.adp.mvc.model

/**
 * Created by Vivek Kumar belongs to APP WORK  on 24-09-2021.
 */
interface MVCModel {
    fun insertUser(user: UserModel): List<UserModel>
    fun getAllUsers(): List<UserModel>
    fun getUserById(id: String): UserModel
}