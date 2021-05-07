package br.com.liebherr.liebherrapp.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.liebherr.liebherrapp.model.MovieDetailsResponse
import br.com.liebherr.liebherrapp.usecase.GetMovieDetailsUseCase
import kotlinx.coroutines.launch

class MovieDetailsViewModel(private val getMovieDetailsUseCase: GetMovieDetailsUseCase) : ViewModel() {

    val onMovieDetailsResponse = MutableLiveData<MovieDetailsResponse>()

    fun getMovieDetails(movieId: String) {
        viewModelScope.launch {
            getMovieDetailsUseCase.invoke(movieId).also {
                onMovieDetailsResponse.postValue(it)
            }
        }
    }

}