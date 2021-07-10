package com.heycode.moviezz.api;

import com.heycode.moviezz.response.MovieSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieAPI {
    //search for movie
    @GET("search/multi")
    Call<MovieSearchResponse> searchMovies(
            @Query("api_key") String apiKey,
            @Query("query") String query,
            @Query("page") String page
    );

    @GET("trending/all/day")
    Call<MovieSearchResponse> dayTrendingMovies(
            @Query("api_key") String apiKey
    );

    @GET("trending/all/week")
    Call<MovieSearchResponse> weekTrendingMovies(
            @Query("api_key") String apiKey
    );
}