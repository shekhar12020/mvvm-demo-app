package com.shekhar.demo.mvvmdatabindinglivedatademo.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class UserLoginDetails : BaseObservable() {

    var userEmail: String? = null
        @Bindable get() = field
        set(userEmail) {
            field = userEmail
            notifyPropertyChanged(BR.userEmail)
        }

    var userPass: String? = null
        @Bindable get() = field
        set(userPass) {
            field = userPass
            notifyPropertyChanged(BR.userPass)
        }
}