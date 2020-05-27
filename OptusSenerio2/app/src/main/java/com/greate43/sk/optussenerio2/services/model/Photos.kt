package com.greate43.sk.optussenerio2.services.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Photos(
    @SerializedName("albumId") val albumId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("url") val url: String,
    @SerializedName("thumbnailUrl") val thumbnailUrl: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        albumId = parcel.readInt(),
        id = parcel.readInt(),
        title = parcel.readString().toString(),
        url = parcel.readString().toString(),
        thumbnailUrl = parcel.readString().toString()
    )

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(albumId)
        dest.writeInt(id)
        dest.writeString(title)
        dest.writeString(url)
        dest.writeString(thumbnailUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Photos> {
        override fun createFromParcel(parcel: Parcel): Photos {
            return Photos(parcel)
        }

        override fun newArray(size: Int): Array<Photos?> {
            return arrayOfNulls(size)
        }
    }
}