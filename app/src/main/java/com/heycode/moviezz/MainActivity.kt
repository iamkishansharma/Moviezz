package com.heycode.moviezz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.heycode.moviezz.api.MovieAPI
import com.heycode.moviezz.request.Services
import com.heycode.moviezz.response.MovieSearchResponse
import com.heycode.moviezz.utils.Constants
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    lateinit var button: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.findViewById<FloatingActionButton>(R.id.buttonMain)
        button.setOnClickListener {
            getRetrofitResponse()
        }
    }

    private fun getRetrofitResponse() {
        val movieApi: MovieAPI = Services.getMovieApi()

        val responseCall: Call<MovieSearchResponse> = movieApi.searchMovies(
            Constants.API_KEY,
            "Tom",
            "1"
        )
        // Implement Callback
    }
}