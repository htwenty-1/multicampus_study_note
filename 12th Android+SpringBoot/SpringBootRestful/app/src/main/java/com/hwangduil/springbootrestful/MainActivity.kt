package com.hwangduil.springbootrestful

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import java.lang.reflect.Member

data class MemberDto(val id:String, val pwd:String, val name:String, val email:String, val auth:Int)

interface ReadyService {
    // 1. 문자열 받기
    @GET("/base")
    fun base(): Call<String>

    // 2. 문자열 보내고 받기
    @GET("/conParamGet")
    fun conParamGet(@Query("title") title:String):Call<String>

    // 3. 객체를 보내고 받기
    @POST("/getMember")
    fun getMember(@Body mem:MemberDto):Call<MemberDto>

    // 4. 리스트 보내기
    @POST("/dbTest")
    fun dbTest() : Call<List<MemberDto>>
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val policy = ThreadPolicy
                     .Builder()
                     .permitAll()
                     .build()

        StrictMode.setThreadPolicy(policy)

        // Gson은 Java객체를 JSON으로 변환할 수 있다.
        val gson = GsonBuilder()
                   .setLenient()
                   .create()

        // localhost 대신에 ip 주소 넣기
        val retrofit = Retrofit.Builder()
                       .baseUrl("http://192.168.35.73:3000/")
                       .addConverterFactory(GsonConverterFactory.create(gson))  // object, integer를 리턴받는 경우
                       .addConverterFactory(ScalarsConverterFactory.create())   // 문자열을 리턴받는 경우
                       .build()

        val service = retrofit.create(ReadyService::class.java)     // 인터페이스를 클래스로 생성


        // 1. 문자열 받기
        // val call = service.base()       // 객체로 생성한 인터페이스 내부 함수

        // 2. 문자열 보내고 받기
        // val call = service.conParamGet("제목입니다.")
        // val response = call.execute()   // 실행

        // 3. 객체를 보내고 받기
        // val call = service.getMember(MemberDto("hong", "111", "홍길동", "hong@korea.com", 1))
        // val response = call.execute()

        val call = service.dbTest()
        val response = call.execute()

        if(response.isSuccessful) {
            if(response.code() == 200) {    // 서버로부터 받는 응답이 200(성공)일 때

                // 1.
                // val base: String? = response.body()
                // println("base : $base")

                // 2.
                // val str:String? = response.body()
                // println("str : $str")

                // 3.
                // val dto:MemberDto? = response.body()
                // println(dto)
                // println(dto?.id)

                // 4.
                val list: List<MemberDto>? = response.body()
                println("list: $list")
                println(list?.get(0))
            }
        }
    }
}