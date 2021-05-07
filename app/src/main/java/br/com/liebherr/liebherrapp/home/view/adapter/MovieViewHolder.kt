package br.com.liebherr.liebherrapp.home.view.adapter

import androidx.recyclerview.widget.RecyclerView
import br.com.liebherr.liebherrapp.databinding.LayoutMoviesListItemBinding
import br.com.liebherr.liebherrapp.model.Movie

class MovieViewHolder(private val binding: LayoutMoviesListItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Movie) {

        this.binding.apply {
            title.text = item.title

            executePendingBindings()
        }
    }

}