package com.heycode.moviezz.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.heycode.moviezz.model.MovieModel
import com.heycode.moviezz.repository.MovieRepository

class MovieViewModel : ViewModel() {
    private val movieRepo: MovieRepository = MovieRepository().getInstance()

    //Live data coming from repository
    public fun getMovies(): LiveData<List<MovieModel>> {
        return movieRepo.getMovies()
    }

}