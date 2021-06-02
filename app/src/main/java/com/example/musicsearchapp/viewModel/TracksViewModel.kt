package com.example.musicsearchapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musicsearchapp.models.Track
import com.example.musicsearchapp.models.TrackResponse
import com.example.musicsearchapp.repository.TracksRepository

class TracksViewModel : ViewModel() {

    var tracksResponse = MutableLiveData<TrackResponse>()
    var track = MutableLiveData<Track>()
    val uiEventValue = MutableLiveData<Int>()

    private val _hide = MutableLiveData(1)
    val hide: MutableLiveData<Int> = _hide

    init {
        val userRepository: TracksRepository by lazy {
            TracksRepository
        }
        tracksResponse = userRepository.getTracks()
    }

//    fun onClickActionGridAdapter(selectedCharacter: Personage, type: Int) {
//        character.value = selectedCharacter
//        onActionViewModel(type)
//    }

    private fun onActionViewModel(type: Int) {
        uiEventValue.value = type
    }

}