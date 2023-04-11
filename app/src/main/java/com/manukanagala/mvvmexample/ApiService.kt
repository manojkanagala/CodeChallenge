package com.manukanagala.mvvmexample

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("smartphones")
    suspend fun getSmartphone(): Response<PhoneList>
}