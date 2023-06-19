package com.aplus.news.domain.repository

import com.aplus.news.domain.model.News
import com.aplus.news.utils.ResponseResult
import kotlinx.coroutines.flow.Flow

interface NewsApiRepository {

    suspend fun getNews(): Flow<ResponseResult<List<News>>>

}
