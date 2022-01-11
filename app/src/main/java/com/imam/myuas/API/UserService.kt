package com.imam.myuas.API


import com.imam.myuas.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface UserService {
    @FormUrlEncoded
    @POST("nyacak/dosen.php")
    fun userLogin(
            @Field("username") username:String,
            @Field("password") password:String
    ): Call<LoginResponse>
}