package com.shekhar.demo.mvvmdatabindinglivedatademo.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class UserLoginDetails : BaseObservable() {

    var userPhone: String? = null
        @Bindable get() = field
        set(userPhone) {
            field = userPhone
            notifyPropertyChanged(BR.userPhone)
        }

    var userPass: String? = null
        @Bindable get() = field
        set(userPass) {
            field = userPass
            notifyPropertyChanged(BR.userPass)
        }
}