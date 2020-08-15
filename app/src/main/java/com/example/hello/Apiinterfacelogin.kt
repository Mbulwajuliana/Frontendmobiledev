package com.example.hello

import android.telecom.Call
import okhttp3.Call
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface Apiinterfacelogin {
    @POST(value "login")
    fun loginStudent(@Body requestBody: RequestBody) : Call<LoginResponse>
}