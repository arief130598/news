package com.aplus.news.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aplus.news.domain.model.News
import com.aplus.news.domain.usecases.NewsApiUseCases
import com.aplus.news.utils.ResponseResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsApiUseCases: NewsApiUseCases
) : ViewModel() {

    private val _news: MutableStateFlow<ResponseResult<List<News>>> =
        MutableStateFlow(ResponseResult.Loading)
    val news = _news.asStateFlow()

    init {
        getNews()
    }

    private fun getNews(){
        viewModelScope.launch {
            newsApiUseCases.getNews().flowOn(Dispatchers.IO)
                .catch { _news.emit(ResponseResult.Error(Throwable(it.toString()))) }
                .collectLatest { _news.emit(it) }
        }
    }
}