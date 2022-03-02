package com.hwangduil.memberspringrestful

import retrofit2.Call
import retrofit2.http.GET

interface MemberService {

    @GET("/allMember")
    fun allMember(): Call<List<MemberDto>>
}

class MemberDao {

    companion object {
        var memberDao:MemberDao? = null

        fun getInstance(): MemberDao {

            if(memberDao == null) {
                memberDao = MemberDao()
            }

            return memberDao!!
        }
    }

    fun allMember(): List<MemberDto> {
        val retrofit = RetrofitClient.getInstance()
        val service = retrofit?.create(MemberService::class.java)
        val call = service?.allMember()

        val response = call?.execute()

        return response?.body() as ArrayList<MemberDto>
    }

}