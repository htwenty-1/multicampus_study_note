package com.hwangduil.bbssystem.dao

import com.hwangduil.bbssystem.dto.MemberDto
import com.hwangduil.bbssystem.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MemberService {

    @POST("/m.login")
    fun loginM(@Body dto:MemberDto): Call<MemberDto>
}

class MemberDao {

    companion object {
        var memberDao: MemberDao? = null
        fun getInstance() : MemberDao {
            if(memberDao == null) {
                memberDao = MemberDao()
            }

            return memberDao!!
        }
    }

    fun loginM(dto:MemberDto) : MemberDto {
        val retrofit = RetrofitClient.getInstance()
        val service = retrofit?.create(MemberService::class.java)
        val call = service?.loginM(dto)

        val response = call?.execute()

        return response?.body() as MemberDto
    }

}