package com.hwangduil.memberspringrestful

import android.os.Parcel
import android.os.Parcelable

class MemberDto(val id:String?, val pwd:String?, val name:String?, val email:String?, val auth:Int) : Parcelable {

    constructor(parcel: Parcel):this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt()) {}

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel?, p1: Int) {
        parcel?.writeString(id)
        parcel?.writeString(pwd)
        parcel?.writeString(name)
        parcel?.writeString(email)
        parcel?.writeInt(auth)
    }

    companion object CREATOR : Parcelable.Creator<MemberDto> {
        override fun createFromParcel(parcel: Parcel): MemberDto {
            return MemberDto(parcel)
        }

        override fun newArray(size: Int): Array<MemberDto?> {
            return arrayOfNulls(size)
        }
    }
}