package com.shekhar.demo.mvvmdatabindinglivedatademo.viewmodel

import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import com.shekhar.demo.mvvmdatabindinglivedatademo.base.BaseViewModel
import com.shekhar.demo.mvvmdatabindinglivedatademo.model.UserLoginDetails

open class UserLoginViewModel : BaseViewModel() {

    val userDetails = MutableLiveData<UserLoginDetails>()

    fun doLoginRequest(userLoginDetails: UserLoginDetails?) {
        println("Login Button Clicked : " + userLoginDetails?.userPass + " | " + userLoginDetails?.userPhone)
    }

    private fun handleSuccessResponse() {

    }

    private fun handleFailureResponse() {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}