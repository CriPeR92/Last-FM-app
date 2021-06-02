package com.example.rickmortyapi.utils.retrofit

import com.example.musicsearchapp.BuildConfig
import com.example.musicsearchapp.models.TrackResponse
import com.google.gson.internal.GsonBuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {

    @GET("2.0/")
    fun getTracks(@Query("method") method : String = "track.search", @Query("track") track : String?, @Query("page") page : Int?, @Query("api_key") api_key : String = BuildConfig.API_KEY, @Query("format") format : String = "json"): Call<TrackResponse>

}