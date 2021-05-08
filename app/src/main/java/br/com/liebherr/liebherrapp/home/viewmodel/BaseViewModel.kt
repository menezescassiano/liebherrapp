package br.com.liebherr.liebherrapp.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    val genericError = MutableLiveData<Exception>()
}
