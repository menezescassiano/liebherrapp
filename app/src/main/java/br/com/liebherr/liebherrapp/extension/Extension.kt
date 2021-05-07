package br.com.liebherr.liebherrapp.extension

import android.app.Activity
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import br.com.liebherr.liebherrapp.R

fun AppCompatActivity.bindingContentView(layout: Int): ViewDataBinding {
    return DataBindingUtil.setContentView(this, layout)
}

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, expression: (T?) -> Unit) {
    liveData.observe(this, Observer(expression))
}

fun Activity.defaultNavController(
    @NavigationRes navGraphId: Int
) = findNavController(R.id.fragment_container).apply {
    graph = navInflater.inflate(navGraphId)
}

fun NavController.defaultNavigate(
    @IdRes resId: Int,
    args: Bundle? = null,
    popStack: Boolean = false,
    navOptionsBuilder: NavOptions.Builder = defaultNavOptionsBuilder()
) {
    val navOptions = navOptionsBuilder
        .apply { if (popStack) setPopUpTo(graph.id, true) }
        .build()

    navigate(resId, args, navOptions)
}

fun defaultNavOptionsBuilder() = NavOptions.Builder()
    .setEnterAnim(R.anim.fast_fade_in)
    .setExitAnim(R.anim.fast_fade_out)

inline fun <reified VM : ViewModel> Fragment.activityViewModel(): Lazy<VM> = lazy {
    ViewModelProvider(requireActivity()).get(VM::class.java)
}