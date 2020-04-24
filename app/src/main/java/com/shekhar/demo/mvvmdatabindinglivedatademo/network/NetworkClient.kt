package com.amit.app.data.network

import com.shekhar.demo.mvvmdatabindinglivedatademo.model.apirequest.LoginRequest
import com.shekhar.demo.mvvmdatabindinglivedatademo.viewmodel.UserLoginViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.io.IOException

class NetworkClient constructor(networkServices: NetworkServices?) {
    var mNetworkServices: NetworkServices? = null
    val internetError: String = "Please check your internet connection."

    init {
        this.mNetworkServices = networkServices
    }

    private fun getFailureMessage(t: Throwable?): String {
        if (t is IOException) {
            return internetError
        } else {
            return t?.message.toString()
        }
    }

    /**
     * To call api for server LOGIN
     */
    fun doLoginApiCall(
        loginRequest: LoginRequest,
        mViewModel: UserLoginViewModel
    ): Disposable? {
        return mNetworkServices?.doLogin(loginRequest)
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribeOn(Schedulers.io())
            ?.subscribe(
                { t ->
                    mViewModel.handleSuccessResponse(t)

                }, { t ->
                    mViewModel.handleFailureResponse(getFailureMessage(t))
                })
    }

}