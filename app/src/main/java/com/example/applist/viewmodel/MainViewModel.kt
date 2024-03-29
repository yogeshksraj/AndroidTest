package com.example.applist.viewmodel

import android.app.Application
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.applist.model.FactsListModel
import com.example.applist.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*
* Code by Yogesh
* */


class MainViewModel(application: Application): AndroidViewModel(application) {

    var factData : MutableLiveData<FactsListModel> = MutableLiveData()
    var showLoading : ObservableInt = ObservableInt()

    fun getFactsData(): MutableLiveData<FactsListModel>{

        // calling retrofit method to fetch API data
        NetworkService.instance.getFacts()
            .enqueue(object : Callback<FactsListModel>{
                override fun onFailure(call: Call<FactsListModel>, t: Throwable) {
                    // set object as null if api get fail
                    factData.value = null
                }

                override fun onResponse(call: Call<FactsListModel>, response: Response<FactsListModel>) {
                    // Assign response to live data
                    factData.value = response.body()
                }

            })
        return factData
    }


}