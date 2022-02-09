package com.example.sample30

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// 리사이클러 뷰 : 리스트뷰는 텍스트 정도 밖에 못넣지만.. 리사이클러뷰는 다양한 것을 넣어줄 수 있다
// 예를 들면 인스타그램 포스팅 하나하나가 리사이클러뷰로 만들어진것임

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}