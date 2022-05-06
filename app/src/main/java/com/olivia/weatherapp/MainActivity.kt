package com.olivia.weatherapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import com.olivia.weatherapp.databinding.ActivityMainBinding
import com.olivia.weatherapp.presentation.ListItem
import com.olivia.weatherapp.presentation.WeatherAdapter
import com.olivia.weatherapp.presentation.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: WeatherViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private val weatherAdapter: WeatherAdapter by lazy {
        WeatherAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        setContentView(binding.root)
        init()
    }

    private fun init() {
        setupBinding()
        setupViewModel()
    }

    private fun setupBinding() {
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        binding.recycler.addItemDecoration(dividerItemDecoration)
        binding.recycler.adapter = weatherAdapter
    }

    private fun setupViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.weatherList.collect { list ->
                    val items = when (list.isEmpty()) {
                        true -> listOf(ListItem.HeaderItem)
                        false -> listOf(ListItem.HeaderItem) + list.map { ListItem.DataItem(it) }
                    }
                    weatherAdapter.submitList(items)
                }
            }
        }

        lifecycleScope.launch {
            viewModel.dataLoading.collect {
                binding.swipeRefreshLayout.isRefreshing = it
            }
        }
    }

}