package com.appwork.ada.solid.repo

import com.appwork.ada.solid.entity.UserEntity

/**
 * Created by Vivek Kumar on 12/09/21.
 */
interface UserDataSource {
    fun saveUser(user: UserEntity)
}