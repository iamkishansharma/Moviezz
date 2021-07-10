package com.heycode.moviezz.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.heycode.moviezz.model.MovieModel

// getting multiple popular movies list
class MovieSearchResponse {
    @SerializedName("total_results")
    @Expose()
    private var total_count: Int=0


    @SerializedName("results")
    @Expose()
    private lateinit var movies: List<MovieModel>

    fun getTotalCount(): Int? {
        return total_count
    }

    fun getMovies(): List<MovieModel>? {
        return movies
    }

    override fun toString(): String {
        return "MovieSearchResponse{total_count=$total_count, movies=$movies}"
    }
}