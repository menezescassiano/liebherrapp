package br.com.liebherr.liebherrapp.home.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import br.com.liebherr.liebherrapp.R
import br.com.liebherr.liebherrapp.databinding.FragmentMovieDetailsBinding

class MovieDetailsFragment : Fragment() {

    lateinit var binding: FragmentMovieDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_details, container, false)

        return binding.root
    }

}