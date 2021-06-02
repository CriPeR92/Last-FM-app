package com.example.musicsearchapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.musicsearchapp.models.TrackResponse
import com.example.rickmortyapi.utils.retrofit.APIClient
import com.example.rickmortyapi.utils.retrofit.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object TracksRepository {

    var apiInterface: APIInterface? = null
    private val characterResponse = MutableLiveData<TrackResponse>()

    fun getTracks(): MutableLiveData<TrackResponse> {

//        SessionData.isLoading = true
        apiInterface = APIClient.getClient()?.create(APIInterface::class.java)
        val call = apiInterface!!.getTracks(track = "Believe", page = 1)
        call.enqueue(object : Callback<TrackResponse> {
            @Override
            override fun onResponse(
                call: Call<TrackResponse>,
                response: Response<TrackResponse>,
            ) {
                val tracksResponse = response.body()
                tracksResponse?.let {
                    characterResponse.value = it
                }
//                for (i in characterResponse.value!!.results) {
//                    SessionData.characters.add(i)
//                }
            }

            @Override
            override fun onFailure(call: Call<TrackResponse>, t: Throwable) {
                Log.e("ERROR", t.toString());
            }
        })

        return characterResponse
    }
}