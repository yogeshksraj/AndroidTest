package com.example.applist.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.applist.R
import com.example.applist.databinding.ActivityMainBinding
import com.example.applist.view.adapter.FactsAdapter
import com.example.applist.viewmodel.MainViewModel

/*
* Code by Yogesh
* */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Binding view using databinding
        var binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.progressBar.visibility = View.VISIBLE
        //Get instance of Viewmodel
        var viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]

        // Observe Facts data using live data
        viewModel.getFactsData().observe(this, Observer { factData ->

            title = factData.title
            var factsAdapter = FactsAdapter(factData.rows)
            binding.rvFactsList.layoutManager = LinearLayoutManager(this!!)
            binding.rvFactsList.hasFixedSize()
            binding.rvFactsList.adapter = factsAdapter
            binding.progressBar.visibility = View.GONE
            if (binding.srlRefreshFact.isRefreshing)
                binding.srlRefreshFact.isRefreshing = false
        })

        // set swipe to refresh functionality
        binding.srlRefreshFact.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {

            viewModel.getFactsData()
        })
    }
}
