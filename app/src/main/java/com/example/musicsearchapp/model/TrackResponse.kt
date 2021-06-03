package com.example.musicsearchapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * models to get the API response
 */
@Parcelize
data class TrackResponse(var results: TrackMatches) : Parcelable

@Parcelize
data class TrackMatches(var trackmatches: Tracks) : Parcelable

@Parcelize
data class Tracks(var track: ArrayList<Track>?) : Parcelable

@Parcelize
data class Image(
    var text: String?,
    var size: String?
) : Parcelable

@Parcelize
data class Track(
    var name: String?,
    var artist: String?,
    var url: String?,
    var streamable: String?,
    var listeners: String?,
    var image: ArrayList<Image>?,
    var mbid: String?
) : Parcelable