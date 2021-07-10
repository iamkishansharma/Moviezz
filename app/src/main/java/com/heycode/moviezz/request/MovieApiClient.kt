package com.heycode.moviezz.request

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.heycode.moviezz.AppExecutor
import com.heycode.moviezz.model.MovieModel
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit

class MovieApiClient {
    private var instance: MovieApiClient = MovieApiClient()

    //live data
    private var liveMovies: MutableLiveData<List<MovieModel>> = MutableLiveData<List<MovieModel>>()


    public fun getInstance(): MovieApiClient {
        return instance
    }

    public fun getMovies(): LiveData<List<MovieModel>> {
        return liveMovies
    }

//    public fun searchMovieApi() {
//        val myHandler: Future = AppExecutor().getInstance().getNetworkIO().submit(Runnable {
//            //retrive data from api
//
//        })
//
//        AppExecutor().getInstance().getNetworkIO().schedule(Runnable {
//            myHandler.cancel(true)
//        }, 5000, TimeUnit.MICROSECONDS)
//    }
}