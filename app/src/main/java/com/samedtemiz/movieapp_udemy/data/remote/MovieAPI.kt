package com.samedtemiz.movieapp_udemy.data.remote

import com.samedtemiz.movieapp_udemy.data.remote.dto.MovieDetailDto
import com.samedtemiz.movieapp_udemy.data.remote.dto.MoviesDto
import com.samedtemiz.movieapp_udemy.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {

    //http://www.omdbapi.com/?apiKey=a8044cdc&s=batman
    //http://www.omdbapi.com/?apiKey=a8044cdc&i=tt0372784


    @GET(".")
    suspend fun getMovies(
        @Query("s") searchString: String,
        @Query("apiKey") apiKey : String = API_KEY
    ) : MoviesDto

    @GET(".")
    suspend fun getMovieDetails(
        @Query("i") imdbId: String,
        @Query("apiKey") apiKey : String = API_KEY
    ) : MovieDetailDto

}