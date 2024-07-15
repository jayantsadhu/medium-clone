package com.jsadhu.api.models.requests


import com.jsadhu.api.models.entities.UserSignupCred
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SignUpRequest(
    @Json(name = "user")
    val userSignupCred: UserSignupCred
)