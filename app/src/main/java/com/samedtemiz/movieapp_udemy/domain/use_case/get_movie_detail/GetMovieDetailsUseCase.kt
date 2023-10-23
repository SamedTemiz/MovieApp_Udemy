package com.samedtemiz.movieapp_udemy.domain.use_case.get_movie_detail

import com.samedtemiz.movieapp_udemy.data.remote.dto.toMovieDetail
import com.samedtemiz.movieapp_udemy.data.remote.dto.toMovieList
import com.samedtemiz.movieapp_udemy.domain.model.Movie
import com.samedtemiz.movieapp_udemy.domain.model.MovieDetail
import com.samedtemiz.movieapp_udemy.domain.repository.MovieRepository
import com.samedtemiz.movieapp_udemy.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovieDetails(imdbId: String): Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMovieDetails(imdbId = imdbId)
            emit(Resource.Success(movieDetail.toMovieDetail()))

        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))
        }
    }

}