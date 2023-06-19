package com.aplus.news.di

import com.aplus.news.data.datasource.NewsApi
import com.aplus.news.data.repository.NewsApiImpl
import com.aplus.news.domain.repository.NewsApiRepository
import com.aplus.news.domain.usecases.GetNews
import com.aplus.news.domain.usecases.NewsApiUseCases
import com.facebook.shimmer.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    private val timeout = 15L
    private val BASE_URL: String = "https://60a4954bfbd48100179dc49d.mockapi.io/api/innocent/newsapp/"

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .callTimeout(timeout, TimeUnit.SECONDS)
            .connectTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .writeTimeout(timeout, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideNewsApiService(retrofit: Retrofit): NewsApi =
        retrofit.create(NewsApi::class.java)

    @Provides
    @Singleton
    fun provideNewsApiRepository(newsApi: NewsApi): NewsApiRepository =
        NewsApiImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsApiUseCases(newsApiRepository: NewsApiRepository)
            : NewsApiUseCases = NewsApiUseCases(
        getNews = GetNews(newsApiRepository)
    )

}