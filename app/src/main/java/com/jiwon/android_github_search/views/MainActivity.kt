package com.jiwon.android_github_search.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jiwon.android_github_search.viewmodels.GithubViewModel
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.jiwon.android_github_search.databinding.ActivityMainBinding
import com.jiwon.android_github_search.views.adapters.GithubRepositoryAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewmodel : GithubViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.viewmodel = viewmodel
        binding.lifecycleOwner = this
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()

        val layoutManager = LinearLayoutManager(this)
        binding.repositoryView.layoutManager = layoutManager
        binding.repositoryView.adapter = GithubRepositoryAdapter()


        viewmodel.searchRepository("yolo")
    }
}