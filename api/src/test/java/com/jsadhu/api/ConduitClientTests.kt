package com.jsadhu.api

import com.jsadhu.api.models.entities.UserLoginCred
import com.jsadhu.api.models.entities.UserSignupCred
import com.jsadhu.api.models.requests.LoginRequest
import com.jsadhu.api.models.requests.SignUpRequest
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.random.Random

class ConduitClientTests {

    private val conduitClient = ConduitClient()

    @Test
    fun `POST signup request`() {
        val email = "android.ml${Random.nextInt(1, 99999)}@test.com"
        val username = "ktx_user_${Random.nextInt(1, 99999)}"
        val password = "pass_${Random.nextInt(100, 99999)}"
        val signupReq = SignUpRequest(
            UserSignupCred(email = email, password = password, username = username)
        )
        runBlocking {
            val userResponse = conduitClient.api.signupRequest(signupReq)
            assertEquals(username, userResponse.body()?.user?.username)
        }
    }

    @Test
    fun `POST login request`() {
        val email = "jay1@gmail.com"
        val password = "jayant@1"
        val loginReq = LoginRequest(
            UserLoginCred(email = email, password = password)
        )
        runBlocking {
            val userResponse = conduitClient.api.loginRequest(loginReq)
            assertEquals(email, userResponse.body()?.user?.email)
        }
    }

    @Test
    fun `GET articles`() {
        runBlocking {
            val articles = conduitClient.api.getArticles()
            assertNotNull(articles.body()?.articles)
        }
    }

}