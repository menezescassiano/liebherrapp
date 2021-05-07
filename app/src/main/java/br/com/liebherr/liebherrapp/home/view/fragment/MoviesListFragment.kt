package br.com.liebherr.liebherrapp.home.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import br.com.liebherr.liebherrapp.R
import br.com.liebherr.liebherrapp.databinding.FragmentMoviesListBinding
import br.com.liebherr.liebherrapp.extension.activityViewModel
import br.com.liebherr.liebherrapp.home.viewmodel.MainViewModel
import br.com.liebherr.liebherrapp.home.viewmodel.MoviesListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesListFragment : Fragment() {

    lateinit var binding: FragmentMoviesListBinding
    private val viewModel: MoviesListViewModel by viewModel()
    private val flowViewModel: MainViewModel by activityViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies_list, container, false)

        binding.mytext.setOnClickListener {
            flowViewModel.navigate(MainViewModel.Navigation.MovieDetails)
        }

        viewModel.apply { lifecycle.addObserver(this) }

        return binding.root
    }

}