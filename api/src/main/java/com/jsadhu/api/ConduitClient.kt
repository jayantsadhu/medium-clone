package com.jsadhu.api

import com.jsadhu.api.services.ConduitAPI
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ConduitClient {

    val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl("https://api.realworld.io/api/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val api = retrofit.create(ConduitAPI::class.java)
}