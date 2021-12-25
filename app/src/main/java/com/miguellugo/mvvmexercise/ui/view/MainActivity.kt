package com.miguellugo.mvvmexercise.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.miguellugo.mvvmexercise.databinding.ActivityMainBinding
import com.miguellugo.mvvmexercise.ui.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {
        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, { quoteModel ->
            binding.quoteTextView.text = quoteModel.quote
            binding.authorTextView.text = quoteModel.author
        })

        quoteViewModel.isLoading.observe(this, {
            binding.progressBar.isVisible = it
        })

        binding.containerLayout.setOnClickListener{
            quoteViewModel.randomQuote()
        }
    }
}