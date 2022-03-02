package com.hwangduil.bbssystem.dao

import com.hwangduil.bbssystem.dto.BbsDto
import com.hwangduil.bbssystem.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BbsService {
    @GET("/getBbsList")
    fun getBbsList() : Call<List<BbsDto>>

    @GET("/insertBbs")
    fun insertBbs(@Query("dto") dto:BbsDto)
}

class BbsDao {

    companion object {
        var bbsDao:BbsDao? = null
        fun getInstance() : BbsDao {
            if(bbsDao == null) {
                bbsDao = BbsDao()
            }

            return bbsDao!!
        }
    }

    val retrofit = RetrofitClient.getInstance()
    val service = retrofit?.create(BbsService::class.java)

    fun getBbsList() : List<BbsDto> {
        val call = service?.getBbsList()
        val response = call?.execute()

        return response?.body() as List<BbsDto>
    }

    fun insertBbs(dto:BbsDto) {
        service?.insertBbs(dto)
    }

}