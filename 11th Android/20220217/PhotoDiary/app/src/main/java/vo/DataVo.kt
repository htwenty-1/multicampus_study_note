package vo

import android.os.Parcel
import android.os.Parcelable

class DataVo(var seq:Int, var filePath:String?, var location:String?, var title:String?, var content:String?, var reg:String?) : Parcelable {

    constructor(parcel:Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ){}

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(seq)
        parcel.writeString(filePath)
        parcel.writeString(location)
        parcel.writeString(title)
        parcel.writeString(content)
        parcel.writeString(reg)
    }

    companion object CREATOR : Parcelable.Creator<DataVo> {
        override fun createFromParcel(parcel: Parcel): DataVo {
            return DataVo(parcel)
        }

        override fun newArray(size: Int): Array<DataVo?> {
            return arrayOfNulls(size)
        }
    }
}