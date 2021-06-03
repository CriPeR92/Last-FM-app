package com.example.musicsearchapp.data.retrofit

import com.example.musicsearchapp.BuildConfig
import com.example.musicsearchapp.model.TrackResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {

    /**
     * parameters
     * track = Name of the track to search
     * limit = could be change to be dynamic or we could use an infinite scroll in the recyclerView
     * method, api_key and format are already defined by the api
     */
    @GET("2.0/")
    fun getTracks(
        @Query("method") method: String = "track.search",
        @Query("track") track: String?,
        @Query("limit") limit: Int = 50,
        @Query("api_key") api_key: String = BuildConfig.API_KEY,
        @Query("format") format: String = "json"
    ): Call<TrackResponse>

}