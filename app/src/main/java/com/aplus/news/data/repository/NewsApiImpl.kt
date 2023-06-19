package com.aplus.news.data.repository

import com.aplus.news.data.datasource.NewsApi
import com.aplus.news.domain.model.News
import com.aplus.news.domain.repository.NewsApiRepository
import com.aplus.news.utils.ResponseResult
import com.aplus.news.utils.validateResponse
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsApiImpl @Inject constructor(private val newsApi: NewsApi) : NewsApiRepository {

    override suspend fun getNews(): Flow<ResponseResult<List<News>>> = flow {
        emit(newsApi.getNews().validateResponse())
    }
}