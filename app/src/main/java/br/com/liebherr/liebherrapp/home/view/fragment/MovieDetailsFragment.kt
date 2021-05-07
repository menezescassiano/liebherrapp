package br.com.liebherr.liebherrapp.home.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import br.com.liebherr.liebherrapp.R
import br.com.liebherr.liebherrapp.databinding.FragmentMovieDetailsBinding
import br.com.liebherr.liebherrapp.extension.activityViewModel
import br.com.liebherr.liebherrapp.home.viewmodel.MainViewModel
import br.com.liebherr.liebherrapp.home.viewmodel.MovieDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailsFragment : Fragment() {

    private val flowViewModel: MainViewModel by activityViewModel()
    private val viewModel: MovieDetailsViewModel by viewModel()

    lateinit var binding: FragmentMovieDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_details, container, false)

        binding.movieTitle.text = flowViewModel.selectedMovie.title
        return binding.root
    }

}