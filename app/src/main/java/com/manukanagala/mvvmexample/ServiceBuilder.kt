package com.manukanagala.mvvmexample

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val API_URL = "https://dummyjson.com/products/category/"

    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService by lazy {
        provideRetrofit().create(ApiService::class.java)
    }
}