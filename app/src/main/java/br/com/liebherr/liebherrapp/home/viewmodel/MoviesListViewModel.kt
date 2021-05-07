package br.com.liebherr.liebherrapp.home.viewmodel

import androidx.lifecycle.*
import br.com.liebherr.liebherrapp.model.Movie
import br.com.liebherr.liebherrapp.usecase.GetMoviesUseCase
import kotlinx.coroutines.launch

class MoviesListViewModel(private val getMoviesUseCase: GetMoviesUseCase) : ViewModel(),
    LifecycleObserver {

    val onMoviesSuccessResponse = MutableLiveData<List<Movie>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun getMovies() {
        viewModelScope.launch {
            getMoviesUseCase.invoke().also {
                onMoviesSuccessResponse.postValue(it.moviesList)
            }
        }
    }

}