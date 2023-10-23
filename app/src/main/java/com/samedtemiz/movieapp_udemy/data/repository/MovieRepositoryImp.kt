package com.samedtemiz.movieapp_udemy.data.repository

import com.samedtemiz.movieapp_udemy.data.remote.MovieAPI
import com.samedtemiz.movieapp_udemy.data.remote.dto.MovieDetailDto
import com.samedtemiz.movieapp_udemy.data.remote.dto.MoviesDto
import com.samedtemiz.movieapp_udemy.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(private val api: MovieAPI) : MovieRepository {
    override suspend fun getMovies(search: String): MoviesDto {
       return api.getMovies(searchString = search)
    }

    override suspend fun getMovieDetails(imdbId: String): MovieDetailDto {
        return api.getMovieDetails(imdbId = imdbId)
    }

}