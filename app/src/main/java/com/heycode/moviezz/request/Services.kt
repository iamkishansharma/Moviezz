package com.heycode.moviezz.request

import com.heycode.moviezz.api.MovieAPI
import com.heycode.moviezz.utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Services {
    private val retrofitBuilder: Retrofit.Builder = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    private val retrofit: Retrofit = retrofitBuilder.build()
    private val movieApi = retrofit.create(MovieAPI::class.java)

    fun getMovieApi(): MovieAPI {
        return movieApi
    }
}