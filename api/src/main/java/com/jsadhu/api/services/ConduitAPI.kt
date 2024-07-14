package com.jsadhu.api.services

import com.jsadhu.api.models.ArticlesResponse
import retrofit2.Call
import retrofit2.http.GET

interface ConduitAPI {

    @GET("articles")
    fun getArticles() : Call<ArticlesResponse>
}