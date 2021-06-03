package com.example.musicsearchapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.musicsearchapp.databinding.ItemTrackBinding
import com.example.musicsearchapp.model.Track

/**
 * Adapter of the list of tracks
 */

class TracksAdapter(var fragment: TracksFragment, var list: ArrayList<Track>) :
    RecyclerView.Adapter<TracksAdapter.TracksAdapterViewHolder>() {

    private lateinit var vm: MainViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TracksAdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTrackBinding.inflate(layoutInflater)
        vm = ViewModelProvider(fragment).get(MainViewModel::class.java)
        return TracksAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TracksAdapterViewHolder, position: Int) {
        holder.binding.mainViewModel = vm
        holder.binding.track = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }

    /**
     * Function to order the list using listeners
     */
    fun orderList(type: Int) {
        if (type == 1) {
            list.sortWith { item1, item2 ->
                if (item1.listeners!!.toInt() > item2.listeners!!.toInt()) -1 else if (item1.listeners!!.toInt() < item2.listeners!!.toInt()) 1 else 0
            }
        } else {
            list.sortWith { item1, item2 ->
                if (item1.listeners!!.toInt() < item2.listeners!!.toInt()) -1 else if (item1.listeners!!.toInt() > item2.listeners!!.toInt()) 1 else 0
            }
        }
        this.notifyDataSetChanged()
    }

    class TracksAdapterViewHolder(val binding: ItemTrackBinding) :
        RecyclerView.ViewHolder(binding.root)
}
