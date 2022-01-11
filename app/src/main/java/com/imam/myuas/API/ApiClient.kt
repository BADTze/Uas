package com.imam.myuas.API

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private fun getRetrofitClientInstance(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("http://192.168.43.205/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
    fun getInstance(): UserService{
        return getRetrofitClientInstance().create(UserService::class.java)
    }
}