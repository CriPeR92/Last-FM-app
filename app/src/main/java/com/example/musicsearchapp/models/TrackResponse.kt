package com.example.musicsearchapp.models

import com.google.gson.annotations.SerializedName

data class TrackResponse(@SerializedName("results") var results : TrackMatches)

class TrackMatches(@SerializedName("trackmatches") var trackmatches : Tracks)

class Tracks(@SerializedName("track") var track : ArrayList<Track>?)


class Track(@SerializedName("name") var name : String?,
            @SerializedName("artist") var artist : String?,
            @SerializedName("url") var url : String?,
            @SerializedName("streamable") var streamable : String?,
            @SerializedName("listeners") var listeners : String?,
            @SerializedName("image") var image : Any?,
            @SerializedName("mbid") var mbid : Any?)