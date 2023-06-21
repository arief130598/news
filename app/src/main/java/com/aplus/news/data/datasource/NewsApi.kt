package com.aplus.news.data.datasource

import com.aplus.news.domain.model.News
import retrofit2.Response
import retrofit2.http.GET

interface NewsApi {

    @GET("articles")
    suspend fun getNews(): Response<List<News>>

}