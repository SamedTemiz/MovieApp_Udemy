package com.samedtemiz.movieapp_udemy.domain.repository

import com.samedtemiz.movieapp_udemy.data.remote.dto.MovieDetailDto
import com.samedtemiz.movieapp_udemy.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(search: String): MoviesDto
    suspend fun getMovieDetails(imdbId: String): MovieDetailDto

}