package com.deneb.apps.features.apods

import android.os.Parcel
import android.os.Parcelable
import com.deneb.apps.core.platform.KParcelable

data class ApodView(val date: String,
                    val url: String,
                    val title: String?,
                    val description: String?,
                    val media_type: String?): KParcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        with(parcel) {
            parcel.writeString(date)
            parcel.writeString(url)
            parcel.writeString(title)
            parcel.writeString(description)
            parcel.writeString(media_type)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ApodView> {
        override fun createFromParcel(parcel: Parcel): ApodView {
            return ApodView(parcel)
        }

        override fun newArray(size: Int): Array<ApodView?> {
            return arrayOfNulls(size)
        }
    }

}