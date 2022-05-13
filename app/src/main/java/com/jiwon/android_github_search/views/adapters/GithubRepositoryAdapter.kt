package com.jiwon.android_github_search.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jiwon.android_github_search.data.GithubRepository
import com.jiwon.android_github_search.databinding.GithubRepoItemBinding

class GithubRepositoryAdapter : RecyclerView.Adapter<GithubRepositoryAdapter.GithubRepoViewHolder>() {
    private val repositories = ArrayList<GithubRepository>()

    class GithubRepoViewHolder(
        private val parent : ViewGroup,
        private val binding : GithubRepoItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(repo : GithubRepository){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepoViewHolder {
        return GithubRepoViewHolder(
            parent,
            GithubRepoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GithubRepoViewHolder, position: Int) {
        holder.bind(repositories.get(position))
    }

    override fun getItemCount(): Int {
        return repositories.size
    }


}