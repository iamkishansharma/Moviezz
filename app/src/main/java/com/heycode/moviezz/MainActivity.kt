package com.heycode.moviezz

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.heycode.moviezz.api.MovieAPI
import com.heycode.moviezz.model.MovieModel
import com.heycode.moviezz.request.Services
import com.heycode.moviezz.response.MovieSearchResponse
import com.heycode.moviezz.utils.Constants
import com.heycode.moviezz.viewmodel.MovieViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var button: FloatingActionButton

    private lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(MovieViewModel::class.java)


        button = findViewById(R.id.buttonMain)
        button.setOnClickListener {
            getRetrofitResponse(this)
        }

        movieViewModel.getMovies().observe(this, Observer {

        })
    }

    private fun getRetrofitResponse(context: Context) {
        val movieApi: MovieAPI = Services.getMovieApi()

        val responseCall: Call<MovieSearchResponse> = movieApi.searchMovies(
            Constants.API_KEY,
            "Tom",
            "1"
        )
        // Implement Callback
        val callbackMSR = object : Callback<MovieSearchResponse> {
            override fun onResponse(
                call: Call<MovieSearchResponse>,
                response: Response<MovieSearchResponse>
            ) {
                Log.d("KishanRe", "The response is: ${response.toString()}")
                if (response.code() == 200) {

                    val movies: List<MovieModel>? = (response.body()?.getMovies())
                    if (movies != null) {
                        for (movie in movies) {
                            Log.d("KishanMo", "${movie.title}")
                        }
                    }
                } else {
                    try {
                        Log.d("KishanRe", "The response is: ${response.body().toString()}")
                    } catch (e: Exception) {
                        Log.d("KishanRe", "Error: ${e.message}")
                        e.printStackTrace()
                    }
                }
            }

            override fun onFailure(call: Call<MovieSearchResponse>, t: Throwable) {
                Toast.makeText(context, "Error occured!", Toast.LENGTH_SHORT).show()
            }
        }

        responseCall.enqueue(callbackMSR)
    }
}