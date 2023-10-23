package com.samedtemiz.movieapp_udemy.domain.use_case.get_movies

import com.samedtemiz.movieapp_udemy.data.remote.dto.toMovieList
import com.samedtemiz.movieapp_udemy.domain.model.Movie
import com.samedtemiz.movieapp_udemy.domain.repository.MovieRepository
import com.samedtemiz.movieapp_udemy.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val repository: MovieRepository) {

    fun executeGetMovies(search: String): Flow<Resource<List<Movie>>> = flow {
        try {
            // Loading yollanıyor
            emit(Resource.Loading())

            // MovieList çekiliyor
            val movieList = repository.getMovies(search)

            // Eğer cevap gelirse
            if (movieList.Response.equals("True")) {
                // Listeyi çevirerek yolluyoruz
                emit(Resource.Success(movieList.toMovieList()))
            } else {
                // Gelmezse hata mesajını yolluyoruz
                emit(Resource.Error(message = "No movie found"))
            }

        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))
        }
    }

}