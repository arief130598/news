package com.aplus.news.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aplus.news.MainCoroutineRule
import com.aplus.news.domain.model.News
import com.aplus.news.domain.usecases.GetNews
import com.aplus.news.domain.usecases.NewsApiUseCases
import com.aplus.news.repository.NewsApiRepositoryFake
import com.aplus.news.utils.ResponseResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response

@RunWith(JUnit4::class)
class HomeViewModelTest {

    private lateinit var newsApiUseCases: NewsApiUseCases
    private lateinit var viewModel: HomeViewModel
    private lateinit var newsApiRepositoryFake: NewsApiRepositoryFake

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Rule
    @JvmField
    val instantTaskExecutorRules = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Before
    fun setup(){
        newsApiRepositoryFake = NewsApiRepositoryFake()
        newsApiUseCases = NewsApiUseCases(GetNews(newsApiRepositoryFake))

        viewModel = HomeViewModel(newsApiUseCases)
    }

    @Test
    fun `when getNews is called observe with stateflow when api is success`() {
        runTest {
            assertTrue(
                viewModel.news.value is ResponseResult.Success
            )
            assertEquals(
                ResponseResult.Success(newsApiRepositoryFake.news.body()),
                viewModel.news.value
            )
        }
    }

    @Test
    fun `when getNews is called observe with stateflow when api is failed`() {
        val error = "{}".toResponseBody("application/json".toMediaTypeOrNull())
        val errorResponseNews = Response.error<List<News>>(404, error)
        newsApiRepositoryFake.news = errorResponseNews
        newsApiUseCases = NewsApiUseCases(GetNews(newsApiRepositoryFake))

        viewModel = HomeViewModel(newsApiUseCases)

        runTest {
            assertTrue(
                viewModel.news.value is ResponseResult.Error
            )
        }
    }
}