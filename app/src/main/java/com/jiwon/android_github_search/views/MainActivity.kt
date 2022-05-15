package com.jiwon.android_github_search.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import com.jiwon.android_github_search.viewmodels.GithubViewModel
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
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

        val layoutManager = LinearLayoutManager(this)
        binding.repositoryView.layoutManager = layoutManager
        binding.repositoryView.adapter = GithubRepositoryAdapter()
        binding.repositoryView.addItemDecoration(
            DividerItemDecoration(binding.repositoryView.context, layoutManager.orientation)
        )

        // set search edittext on enter event handle
        binding.searchEdittext.setOnKeyListener { view, keyCode, keyEvent ->
            if(keyCode == KeyEvent.KEYCODE_ENTER){
                viewmodel.searchRepository(binding.searchEdittext.text.toString())
                true
            }else{
                false
            }
        }
    }
}