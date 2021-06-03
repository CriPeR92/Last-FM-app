package com.example.musicsearchapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musicsearchapp.model.TrackResponse
import com.example.musicsearchapp.data.repository.TracksRepository

/**
 * ViewModel
 */

class MainViewModel : ViewModel() {

    private val trackRepository = TracksRepository()
    var tracksResponse = MutableLiveData<TrackResponse>()
    var search: String = ""
    val hideProgress = MutableLiveData(0)
    val hideButton = MutableLiveData(0)

    /**
     * Function that invokes the repository with the parameters requiered, only if the input is valid
     */
    fun search() {
        if (Validator.validateInput(search)) {
            hideProgress.value = 1
            trackRepository.getTracks(search, tracksResponse)
        }
    }

    /**
     * Function to sort the result list, using the amount of listeners
     */
    fun sortList(adapter: TracksAdapter, type: Int) {
        adapter.orderList(type)
    }

}