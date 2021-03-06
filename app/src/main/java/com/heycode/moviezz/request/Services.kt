package com.heycode.moviezz.request

import com.heycode.moviezz.api.MovieAPI
import com.heycode.moviezz.utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Services {
    private val retrofitBuilder: Retrofit.Builder = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    private val retrofit: Retrofit = retrofitBuilder.build()
    private val movieApi: MovieAPI = retrofit.create(MovieAPI::class.java)

    public fun getMovieApi(): MovieAPI {
        return movieApi
    }
}