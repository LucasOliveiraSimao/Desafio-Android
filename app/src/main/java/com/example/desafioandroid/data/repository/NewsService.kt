package com.example.desafioandroid.data.repository

import com.example.desafioandroid.data.model.News
import retrofit2.Response
import retrofit2.http.GET

interface NewsService {
    @GET("api.json?rss_url=https://g1.globo.com/rss/g1/carros")
    suspend fun getAllNews(): Response<News>
}