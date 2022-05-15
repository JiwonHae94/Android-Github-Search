package com.jiwon.android_github_search.views.adapters

import android.icu.text.CompactDecimalFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.jiwon.android_github_search.data.GithubRepository
import com.jiwon.android_github_search.databinding.GithubRepoItemBinding
import java.util.*

class GithubRepositoryAdapter : RecyclerView.Adapter<GithubRepositoryAdapter.GithubRepoViewHolder>() {
    private var repositories = emptyList<GithubRepository>()

    internal fun updateRepositories(
        repositories: List<GithubRepository>
    ){
        this.repositories = repositories

        // notify update to the data
        notifyDataSetChanged()
    }

    class GithubRepoViewHolder(
        private val binding : GithubRepoItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(repo : GithubRepository){
            binding.repository = repo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepoViewHolder {
        return GithubRepoViewHolder(
            GithubRepoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).apply {
                this.stargazerFormat = CompactDecimalFormat.getInstance(Locale.getDefault(), CompactDecimalFormat.CompactStyle.SHORT)
            }
        )
    }

    override fun onBindViewHolder(holder: GithubRepoViewHolder, position: Int) {
        holder.bind(repositories.get(position))
    }

    override fun getItemCount(): Int {
        return repositories.size
    }

    companion object{
        @JvmStatic
        @BindingAdapter("repositories")
        fun bindRepository(view:RecyclerView, repositories : MutableLiveData<List<GithubRepository>>){
            val adapter = view.adapter as GithubRepositoryAdapter
            adapter.updateRepositories(repositories.value ?: emptyList())
        }
    }


}