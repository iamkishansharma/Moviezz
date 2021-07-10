package com.heycode.moviezz.repository

import androidx.lifecycle.LiveData
import com.heycode.moviezz.model.MovieModel
import com.heycode.moviezz.request.MovieApiClient

class MovieRepository() {
    private var instance: MovieRepository = MovieRepository()

    private val movieApiClient: MovieApiClient = MovieApiClient().getInstance()

    public fun getInstance(): MovieRepository {
        return instance
    }

    //Live data coming from remote server
    public fun getMovies(): LiveData<List<MovieModel>> {
        return movieApiClient.getMovies()
    }

}