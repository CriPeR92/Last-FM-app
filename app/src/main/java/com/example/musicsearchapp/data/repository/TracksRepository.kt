package com.example.musicsearchapp.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.musicsearchapp.model.TrackResponse
import com.example.musicsearchapp.ui.main.MainViewModel
import com.example.rickmortyapi.utils.retrofit.APIClient
import com.example.rickmortyapi.utils.retrofit.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object TracksRepository {

    var apiInterface: APIInterface? = null
    val trackResponse = MutableLiveData<TrackResponse>()

    fun getTracks(vm: MainViewModel, searchTrack : String): MutableLiveData<TrackResponse> {

//        SessionData.isLoading = true
        if (searchTrack.isNotEmpty()) {
            apiInterface = APIClient.getClient()?.create(APIInterface::class.java)
            val call = apiInterface!!.getTracks(track = searchTrack, page = 1)
            call.enqueue(object : Callback<TrackResponse> {
                @Override
                override fun onResponse(
                    call: Call<TrackResponse>,
                    response: Response<TrackResponse>,
                ) {

                    trackResponse.value = response.body()
                    vm.tracksResponse = trackResponse
//                for (i in characterResponse.value!!.results) {
//                    SessionData.characters.add(i)
//                }
                }

                @Override
                override fun onFailure(call: Call<TrackResponse>, t: Throwable) {
                    Log.e("ERROR", t.toString());
                }
            })


        }
        return trackResponse
    }
}