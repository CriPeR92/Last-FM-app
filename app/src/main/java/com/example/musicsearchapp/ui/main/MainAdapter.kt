package com.example.musicsearchapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.musicsearchapp.databinding.ItemTrackBinding
import com.example.musicsearchapp.model.Track

class MainAdapter (var fragment: MainFragment, var list: ArrayList<Track>) : RecyclerView.Adapter<MainAdapter.GridCharacterViewHolder>(){
    private lateinit var vm: MainViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridCharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTrackBinding.inflate(layoutInflater)
        vm = ViewModelProvider(fragment).get(MainViewModel::class.java)

        return GridCharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GridCharacterViewHolder, position: Int) {
        holder.binding.mainViewModel = vm
        holder.binding.track = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class GridCharacterViewHolder(val binding: ItemTrackBinding) : RecyclerView.ViewHolder(binding.root)
}