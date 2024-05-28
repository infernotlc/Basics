package com.tlh.retrofitcik.services

import com.tlh.retrofitcik.models.User
import com.tlh.retrofitcik.models.UserLogin
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface IDummyService {

    @POST("auth/login")
    fun userLogin( @Body userLogin: UserLogin ) : Call<User>



}