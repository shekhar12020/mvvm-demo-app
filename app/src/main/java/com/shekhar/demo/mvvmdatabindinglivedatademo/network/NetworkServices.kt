package com.amit.app.data.network

import com.shekhar.demo.mvvmdatabindinglivedatademo.model.apirequest.LoginRequest
import com.shekhar.demo.mvvmdatabindinglivedatademo.model.apiresponse.LoginResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkServices {
    @POST("api/login")
    fun doLogin(@Body loginRequest: LoginRequest): Observable<Response<LoginResponse>>
}