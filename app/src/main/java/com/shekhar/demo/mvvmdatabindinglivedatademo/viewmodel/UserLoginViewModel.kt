package com.shekhar.demo.mvvmdatabindinglivedatademo.viewmodel

import android.util.Log
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import com.shekhar.demo.mvvmdatabindinglivedatademo.base.BaseViewModel
import com.shekhar.demo.mvvmdatabindinglivedatademo.model.UserLoginDetails
import com.shekhar.demo.mvvmdatabindinglivedatademo.model.apirequest.LoginRequest
import com.shekhar.demo.mvvmdatabindinglivedatademo.model.apiresponse.LoginResponse
import retrofit2.Response

open class UserLoginViewModel : BaseViewModel() {

    fun doLoginRequest(userLoginDetails: UserLoginDetails?) {
        println("Login Button Clicked : " + userLoginDetails?.userPass + " | " + userLoginDetails?.userEmail)
        val errorMessage = isValid(userLoginDetails)

        if (errorMessage.isEmpty()) {
            val request = LoginRequest(userLoginDetails?.userEmail, userLoginDetails?.userPass)
            mDisposable = mNetworkClient.doLoginApiCall(request, this)!!

        } else {
            showMessage(errorMessage)
        }
    }

    private fun isValid(userLoginDetails: UserLoginDetails?): String {
        if (userLoginDetails?.userEmail == null || userLoginDetails?.userEmail.equals("")) {
            return "Please enter mobile no."
        }
        if (userLoginDetails.userPass == null || userLoginDetails?.userPass.equals("")) {
            return "Please enter password"
        }
        return ""
    }

    fun handleSuccessResponse(t: Response<LoginResponse>) {
        Log.d("success response", t.isSuccessful.toString())
        t.body()?.token?.let { showMessage(it) }
    }

    fun handleFailureResponse(failureMessage: String) {
        Log.d("failure response", failureMessage)
        showMessage(failureMessage)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}