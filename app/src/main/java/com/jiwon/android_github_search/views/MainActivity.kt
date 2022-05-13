package com.jiwon.android_github_search.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jiwon.android_github_search.R
import com.jiwon.android_github_search.viewmodels.GithubViewModel
import androidx.activity.viewModels
import com.jiwon.android_github_search.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewmodel : GithubViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}