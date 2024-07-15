package com.jsadhu.api.services

import com.jsadhu.api.models.requests.LoginRequest
import com.jsadhu.api.models.requests.SignUpRequest
import com.jsadhu.api.models.responses.ArticlesResponse
import com.jsadhu.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ConduitAPI {

    @POST("users")
    suspend fun signupRequest(
        @Body signUpCredReq: SignUpRequest
    ) : Response<UserResponse>

    @POST("users/login")
    suspend fun loginRequest(
        @Body loginCredReq: LoginRequest
    ) : Response<UserResponse>

    @GET("articles")
    suspend fun getArticles() : Response<ArticlesResponse>

}