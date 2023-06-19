package com.aplus.news.domain.usecases

import com.aplus.news.domain.model.News
import com.aplus.news.domain.repository.NewsApiRepository
import com.aplus.news.utils.ResponseResult
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetNews @Inject constructor(private val repository: NewsApiRepository) {

    suspend operator fun invoke() : Flow<ResponseResult<List<News>>> =
        repository.getNews()
}