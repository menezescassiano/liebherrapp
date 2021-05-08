package br.com.liebherr.liebherrapp.home.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.viewModelScope
import br.com.liebherr.liebherrapp.extension.safeRun
import br.com.liebherr.liebherrapp.model.Movie
import br.com.liebherr.liebherrapp.usecase.GetMoviesUseCase
import kotlinx.coroutines.launch

class MoviesListViewModel(private val getMoviesUseCase: GetMoviesUseCase) : BaseViewModel(), LifecycleObserver {

    val onMoviesSuccessResponse = MutableLiveData<List<Movie>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun getMovies() {
        viewModelScope.launch {
            safeRun(
                    onSuccess = {
                        getMoviesUseCase.invoke().also {
                            onMoviesSuccessResponse.postValue(it.moviesList)
                        }
                    })
        }
    }
}
