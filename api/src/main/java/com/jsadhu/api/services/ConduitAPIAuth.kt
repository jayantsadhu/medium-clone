package com.jsadhu.api.services

import com.jsadhu.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface ConduitAPIAuth {

    @GET("user")
    suspend fun getUser(

    ) : Response<UserResponse>
}