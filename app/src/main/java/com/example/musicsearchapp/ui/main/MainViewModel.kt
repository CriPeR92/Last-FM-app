package com.example.musicsearchapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musicsearchapp.model.Track
import com.example.musicsearchapp.model.TrackResponse
import com.example.musicsearchapp.data.repository.TracksRepository

class MainViewModel : ViewModel() {

    val trackRepository = TracksRepository

    var tracksResponse = MutableLiveData<TrackResponse>()
    var search : String = ""
    val uiEventValue = MutableLiveData<Int>()
    val hide = MutableLiveData(0)

    init {
        val userRepository: TracksRepository by lazy {
            TracksRepository
        }
        tracksResponse = userRepository.getTracks(this, "")
    }

    fun onClickActionGridAdapter() {
        hide.value = 1
        tracksResponse = trackRepository.getTracks(this, search)
    }

    private fun onActionViewModel(type: Int) {
        uiEventValue.value = type
    }

}