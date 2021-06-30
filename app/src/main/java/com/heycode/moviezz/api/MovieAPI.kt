package com.heycode.moviezz.api

import com.heycode.moviezz.response.MovieSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

public interface MovieAPI {
    //search for movie
    @GET
    fun searchMovies(
        @Query("api_key")
        apiKey: String,
        @Query("query")
        query: String,
        @Query("page")
        page: String
    ): Call<MovieSearchResponse>
}