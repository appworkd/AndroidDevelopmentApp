package com.appwork.ada.adp.mvc.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.appwork.ada.adp.mvc.controller.MVCController
import com.appwork.ada.adp.mvc.model.MVCModelImpl
import com.appwork.ada.adp.mvc.model.UserModel
import com.appwork.ada.adp.mvc.model.db.UserDb
import com.appwork.ada.adp.mvc.view.adapter.UserAdapter
import com.appwork.ada.adp.mvc.view.adapter.UserAdapter.Interaction
import com.appwork.ada.databinding.ActivityMainMvcactivityBinding

/**
 * Created by Vivek Kumar belongs to APP WORK  on 24-09-2021.
 */
class MVCViewActivityImpl(
    private val context: Context
) : MVCMainActivityView, Interaction {
    private val vbBind: ActivityMainMvcactivityBinding by lazy {
        ActivityMainMvcactivityBinding.inflate(LayoutInflater.from(context))
    }
    private val userAda by lazy {
        UserAdapter(this)
    }
    private val mvcModel = MVCModelImpl(UserDb())
    private val mvcController = MVCController(mvcModel, this)

    override fun bindDataToView() {
        mvcController.onViewLoaded()
    }

    override fun showAllUsers(usersList: List<UserModel>) {
        vbBind.tvInfo.text = ""
        userAda.submitList(usersList)
    }

    override fun updateOnAddUser(usersList: List<UserModel>) {
        vbBind.tvInfo.text = ""
        userAda.submitList(usersList)
        userAda.notifyAdapter()
    }

    override fun updateOnSingleUserSelection(user: UserModel) {
        vbBind.tvInfo.text = ""
        vbBind.tvInfo.text = user.toString()
    }

    override fun showError(msg: String) {
        vbBind.tvInfo.text = ""
        vbBind.tvInfo.text = msg
    }

    override fun getRootView(): View {
        return vbBind.root
    }

    private fun setUpRecyclerView() {
        vbBind.rvUser.apply {
            adapter = userAda
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun initView() {
        vbBind.btnAddUser.setOnClickListener {
            mvcController.addNewUser(UserModel("Vivek", "123"))
        }
        vbBind.btnAllUsers.setOnClickListener {
            mvcController.showAllUser()
        }
        vbBind.btnGetUser.setOnClickListener {
            mvcController.getUser("0")
        }
        setUpRecyclerView()
    }

    override fun onItemSelected(position: Int, item: UserModel) {

    }
}