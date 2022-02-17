package com.example.sample37

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

// 동적 컴포넌트 생성하기
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
        var childLayout:LinearLayout? = null

        val range = 8
        for(i in 0 until range) {

            // make layout inside layout
            if(i % 3 == 0) {
                childLayout = LinearLayout(this)
                childLayout.orientation = LinearLayout.HORIZONTAL
                val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100)
                childLayout.layoutParams = layoutParams
            }

            // make button
            val btnParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)   // 버튼이 들어갈 자리 가로 세로 매치
            btnParams.weight = 1.0f

            val normalBtn = Button(this).apply {
                text = (i + 1).toString()  // i + 1은 버튼의 제목
                layoutParams = btnParams
                id = i

                setOnClickListener {
                    val myToast = Toast.makeText(this.context, "${id+1}번 버튼 클릭됨", Toast.LENGTH_SHORT)
                    myToast.show()
                }

            }

            childLayout?.addView(normalBtn)

            if (i % 3 == 2 || i == (range - 1)) {
                linearLayout.addView(childLayout)
            }

        }
    }
}