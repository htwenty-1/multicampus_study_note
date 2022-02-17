package dto

import android.os.Parcel
import android.os.Parcelable

class DataDto(var imagePath:String?,
              var title:String?,
              var content:String?,
              var location:String?,
              var date:String?) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
    )

    companion object CREATOR : Parcelable.Creator<DataDto> {
        override fun createFromParcel(parcel: Parcel): DataDto {
            return DataDto(parcel)
        }

        override fun newArray(size: Int): Array<DataDto?> {
            return arrayOfNulls(size)
        }
    }

    override fun writeToParcel(parcel: Parcel?, p1: Int) {
        parcel?.writeString(imagePath)
        parcel?.writeString(title)
        parcel?.writeString(content)
        parcel?.writeString(location)
        parcel?.writeString(date)
    }

    override fun describeContents(): Int {
        return 0
    }
}