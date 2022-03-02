package com.hwangduil.memberspringrestful

import android.os.StrictMode
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class RetrofitClient {

    companion object {
        private var instance: Retrofit? = null

        fun getInstance(): Retrofit? {

            if(instance == null) {

                val policy = StrictMode.ThreadPolicy
                    .Builder()
                    .permitAll()
                    .build()

                StrictMode.setThreadPolicy(policy)

                // Gson은 Java객체를 JSON으로 변환할 수 있다.
                val gson = GsonBuilder()
                    .setLenient()
                    .create()

                // localhost 대신에 ip 주소 넣기
                instance = Retrofit.Builder()
                    .baseUrl("http://192.168.35.73:3000/")
                    .addConverterFactory(GsonConverterFactory.create(gson))  // object, integer를 리턴받는 경우
                    .addConverterFactory(ScalarsConverterFactory.create())   // 문자열을 리턴받는 경우
                    .build()
            }

            return instance

        }
    }

}