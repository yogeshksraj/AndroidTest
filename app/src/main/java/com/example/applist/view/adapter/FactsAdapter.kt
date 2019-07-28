package com.example.applist.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applist.databinding.AdapterFactsBinding
import com.example.applist.model.FactsModel

/*
* Code by Yogesh
* */

class FactsAdapter(val factsList: List<FactsModel>) : RecyclerView.Adapter<FactsAdapter.FactsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactsViewHolder {

        // Inflate view with data binding
        var inflater = LayoutInflater.from(parent.context)
        var adapterFactsBinding = AdapterFactsBinding.inflate(inflater)
        return FactsViewHolder(adapterFactsBinding)

    }

    override fun getItemCount(): Int {
        return factsList.size
    }

    override fun onBindViewHolder(holder: FactsViewHolder, position: Int) {
        holder.bind(factsList.get(position))
    }


    class FactsViewHolder(var adapterFactsBinding: AdapterFactsBinding) :
        RecyclerView.ViewHolder(adapterFactsBinding.root) {

        // bind model to adapter
        fun bind(factsModel: FactsModel) {
            adapterFactsBinding.factsModel = factsModel
            adapterFactsBinding.executePendingBindings()
        }

    }
}