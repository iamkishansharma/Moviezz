package com.heycode.moviezz.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.heycode.moviezz.model.MovieModel

class MovieResponse {
    @SerializedName("results")
    @Expose
    private lateinit var movie: MovieModel

    fun getMovie():MovieModel{
        return movie
    }

    override fun toString(): String {
        return "MovieResponse{movie=$movie}"
    }

}