package com.hwangduil.bbssystem.dto

import android.os.Parcel
import android.os.Parcelable
import com.hwangduil.bbssystem.dao.MemberDao

class MemberDto(private var id:String?,
                private var pwd:String?,
                private var name:String?,
                private var email:String?,
                private var auth:Int) : Parcelable {

    constructor(parcel:Parcel) : this(parcel.readString(),
                                      parcel.readString(),
                                      parcel.readString(),
                                      parcel.readString(),
                                      parcel.readInt())

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, p1: Int) {
        parcel.writeString(id)
        parcel.writeString(pwd)
        parcel.writeString(name)
        parcel.writeString(email)
        parcel.writeInt(auth)
    }

    override fun toString(): String {
        return "MemberDto(id=$id, pwd=$pwd, name=$name, email=$email, auth=$auth)"
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