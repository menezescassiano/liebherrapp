package br.com.liebherr.liebherrapp.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val navigationEvent = MutableLiveData<Navigation>()

    fun navigate(navigation: Navigation) {
        navigationEvent.postValue(navigation)
    }

    sealed class Navigation {
        object MoviesList : Navigation()
        object MovieDetails : Navigation()
    }
}