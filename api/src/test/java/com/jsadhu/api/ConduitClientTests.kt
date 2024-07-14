package com.jsadhu.api

import junit.framework.TestCase.assertNotNull
import org.junit.Test

class ConduitClientTests {

    private val conduitClient = ConduitClient()

    @Test
    fun `GET articles`() {
        val articles = conduitClient.api.getArticles().execute()
        assertNotNull(articles.body()?.articles)
    }

}