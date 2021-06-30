package com.heycode.moviezz.model

import android.os.Parcel
import android.os.Parcelable

class MovieModel(
    val id: Int? = null,
    val title: String? = null,
    val poster_path: String? = null,
    val release_date: String? = null,
    val vote_average: Float? = null,
    val movie_overview: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Float::class.java.classLoader) as? Float,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(title)
        parcel.writeString(poster_path)
        parcel.writeString(release_date)
        parcel.writeValue(vote_average)
        parcel.writeString(movie_overview)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieModel> {
        override fun createFromParcel(parcel: Parcel): MovieModel {
            return MovieModel(parcel)
        }

        override fun newArray(size: Int): Array<MovieModel?> {
            return arrayOfNulls(size)
        }
    }
}