package com.example.applist.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
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
        setContentView(R.layout.activity_main)

        //Binding view using databinding
        var binding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //Get instance of Viewmodel
        var viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]

        // Observe Facts data using live data
        viewModel.getFactsData().observe(this, Observer { factData ->

            var factsAdapter  = FactsAdapter(factData.rows)
            binding.rvFactsList.layoutManager = LinearLayoutManager(this)
            binding.rvFactsList.hasFixedSize()
            binding.rvFactsList.adapter = factsAdapter
        })

    }
}
