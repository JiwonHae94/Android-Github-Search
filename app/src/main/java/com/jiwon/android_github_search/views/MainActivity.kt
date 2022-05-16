package com.jiwon.android_github_search.views

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
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

        // hide keyboard when error
        viewmodel.responseError.observe(this, {
            if(it != null){
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
                imm?.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            }
        })
    }
}