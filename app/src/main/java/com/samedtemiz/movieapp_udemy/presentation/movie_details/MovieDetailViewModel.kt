package com.samedtemiz.movieapp_udemy.presentation.movie_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samedtemiz.movieapp_udemy.domain.use_case.get_movie_detail.GetMovieDetailsUseCase
import com.samedtemiz.movieapp_udemy.util.Constants.IMDB_ID
import com.samedtemiz.movieapp_udemy.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val useCase: GetMovieDetailsUseCase,
    private val stateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf<MovieDetailsState>(MovieDetailsState())
    val state : State<MovieDetailsState> = _state


    init{
        stateHandle.get<String>(IMDB_ID)?.let {
            getMovieDetails(it)
        }
    }

    private fun getMovieDetails(imdbId: String){
        useCase.executeGetMovieDetails(imdbId = imdbId).onEach {
            when(it){
                is Resource.Success -> {
                    _state.value = MovieDetailsState(movie = it.data)
                }

                is Resource.Error -> {
                    _state.value = MovieDetailsState(error = it.message ?: "Error")
                }

                is Resource.Loading -> {
                    _state.value = MovieDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}