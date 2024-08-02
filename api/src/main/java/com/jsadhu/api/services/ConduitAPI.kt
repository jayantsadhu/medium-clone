package com.jsadhu.api.services

import com.jsadhu.api.models.entities.Profile
import com.jsadhu.api.models.requests.LoginRequest
import com.jsadhu.api.models.requests.SignUpRequest
import com.jsadhu.api.models.responses.ArticleResponse
import com.jsadhu.api.models.responses.ArticlesResponse
import com.jsadhu.api.models.responses.ProfileResponse
import com.jsadhu.api.models.responses.TagsResponse
import com.jsadhu.api.models.responses.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ConduitAPI {

    @POST("users")
    suspend fun signupRequest(
        @Body signUpCredReq: SignUpRequest
    ) : Response<UserResponse>

    @POST("users/login")
    suspend fun loginRequest(
        @Body loginCredReq: LoginRequest
    ) : Response<UserResponse>

    @GET("profiles/{username}")
    suspend fun getProfile(
        @Path("username") username : String
    ) : Response<ProfileResponse>

    @GET("articles")
    suspend fun getArticles(
//        @Query("tag") tag : String? = null,
//        @Query("author") author : String? = null,
//        @Query("favorited") favorited : String? = null,
//        @Query("limit") limit : String? = null,
//        @Query("offset") offset : String? = null,
    ) : Response<ArticlesResponse>

    @GET("articles/{slug}")
    suspend fun getArticle(
        @Path("slug") slug : String
    ) : Response<ArticleResponse>

    @GET("tags")
    suspend fun getTags() : Response<TagsResponse>
}