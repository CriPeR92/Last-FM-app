package com.example.musicsearchapp.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.musicsearchapp.model.TrackResponse
import com.example.musicsearchapp.data.retrofit.APIClient
import com.example.musicsearchapp.data.retrofit.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TracksRepository {

    var apiInterface: APIInterface? = null

    fun getTracks(
        searchTrack: String,
        trackResponse: MutableLiveData<TrackResponse>
    ) {

        if (searchTrack.isNotEmpty()) {
            apiInterface = APIClient.getClient()?.create(APIInterface::class.java)
            val call = apiInterface!!.getTracks(track = searchTrack)
            call.enqueue(object : Callback<TrackResponse> {
                @Override
                override fun onResponse(
                    call: Call<TrackResponse>,
                    response: Response<TrackResponse>,
                ) {
                    trackResponse.value = response.body()
                }

                @Override
                override fun onFailure(call: Call<TrackResponse>, t: Throwable) {
                    Log.e("ERROR", t.toString());
                }
            })
        }
    }
}