package com.example.musicsearchapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musicsearchapp.model.TrackResponse
import com.example.musicsearchapp.data.repository.TracksRepository

class MainViewModel : ViewModel() {

    private val trackRepository = TracksRepository()
    var tracksResponse = MutableLiveData<TrackResponse>()
    var search: String = ""
    val hideProgress = MutableLiveData(0)
    val hideButton = MutableLiveData(0)

    fun search() {
        hideProgress.value = 1
        trackRepository.getTracks(search, tracksResponse)
    }

    fun sortList(adapter: MainAdapter, type: Int) {
        adapter.orderList(type)
    }

}