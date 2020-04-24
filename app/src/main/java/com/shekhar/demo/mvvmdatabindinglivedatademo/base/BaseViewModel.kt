package com.shekhar.demo.mvvmdatabindinglivedatademo.base

import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amit.app.data.network.NetworkClient
import com.amit.app.data.network.RetrofitApiClient
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel(), Observable {

    protected var mNetworkClient: NetworkClient =
        NetworkClient(RetrofitApiClient.getNetworkServices())

    protected lateinit var mDisposable: Disposable

    protected val messageData = MutableLiveData<String>()

    fun getMessage(): LiveData<String> {
        return messageData
    }

    fun showMessage(message: String) {
        messageData.postValue(message)
    }
}