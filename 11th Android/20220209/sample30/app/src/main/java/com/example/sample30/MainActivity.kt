package com.example.sample30

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// 리사이클러 뷰 : 리스트뷰는 텍스트 정도 밖에 못넣지만.. 리사이클러뷰는 다양한 것을 넣어줄 수 있다
// 예를 들면 인스타그램 포스팅 하나하나가 리사이클러뷰로 만들어진것임

class MainActivity : AppCompatActivity() {

    private val userList = arrayListOf<DataVo>(
        DataVo("황두일", "test", "대전시", 500, "profile_sample"),
        DataVo("박현준", "hJunPark", "서울시", 500, "hjun"),
        DataVo("박정준", "2junPark", "여수시", 500, ""),
        DataVo("김연우", "rudy.kim", "서울시", 1000, ""),
        DataVo("차재윤", "jaeyun", "서울시", 1000, "")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycleView = findViewById<RecyclerView>(R.id.recyclerView)
        val mAdapter = CustomAdapter(this, userList)

        recycleView.adapter = mAdapter

        val layout = LinearLayoutManager(this)
        recycleView.layoutManager = layout

        recycleView.setHasFixedSize(true)       // 리스트에 컴포넌트가 균등하게 들어가도록 함
    }
}