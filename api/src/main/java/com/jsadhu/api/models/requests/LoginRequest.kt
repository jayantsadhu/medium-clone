package com.jsadhu.api.models.requests


import com.jsadhu.api.models.entities.UserLoginCred
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginRequest(
    @Json(name = "user")
    val userLoginCred: UserLoginCred
)