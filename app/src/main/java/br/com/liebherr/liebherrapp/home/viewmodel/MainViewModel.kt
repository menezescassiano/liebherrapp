package br.com.liebherr.liebherrapp.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.liebherr.liebherrapp.model.Movie

class MainViewModel : ViewModel() {

    val navigationEvent = MutableLiveData<Navigation>()
    lateinit var selectedMovie: Movie

    fun navigate(navigation: Navigation) {
        navigationEvent.postValue(navigation)
    }

    sealed class Navigation {
        object MoviesList : Navigation()
        object MovieDetails : Navigation()
    }
}