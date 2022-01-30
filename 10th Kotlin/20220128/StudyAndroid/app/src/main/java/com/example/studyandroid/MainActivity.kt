package com.example.studyandroid

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    // val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        /*  binding을 사용한다면
            setContentView(R.layout.activity_main)
            setContentView(binding.root)

            binding.btnSay.setOnClickListener {
                Log.i(ContentValues.TAG, "btnSay Tapped")
                binding.sayHello.text = "Hello World!"
            }
        */
        super.onCreate(savedInstanceState)

        // layout에 있는 activity_main.xml로 화면 정의
        setContentView(R.layout.activity_main)

        val sayHello:TextView = findViewById(R.id.sayHello)
        val butter = findViewById<Button>(R.id.butter)

        // 이벤트 추가
        butter.setOnClickListener {
            sayHello.text = "What a nice Android World!"

            // Toast 만들기
            val toast = Toast.makeText(this.applicationContext, "button tapped", Toast.LENGTH_SHORT)
            toast.show()    // 토스트 보여주기

            // Alert 보여주기
            AlertDialog.Builder(this@MainActivity)
                .setTitle("Welcome to the Android World!")
                .setMessage("안드로이드 세계에 오신것을 환영합니다!!")
                .setCancelable(false)
                .setNeutralButton("닫기", DialogInterface.OnClickListener {
                    dialog, which -> // 닫기버튼을 눌렀을 때 처리할 로직을 넣어줍니다.
                }).show()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i(ContentValues.TAG, "onStart 실행")
    }

    override fun onResume() {
        super.onResume()
        Log.i(ContentValues.TAG, "onResume 실행")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(ContentValues.TAG, "onRestart 실행")
    }

    override fun onPause() {
        super.onPause()
        Log.i(ContentValues.TAG, "onPause 실행")
    }

    override fun onStop() {
        super.onStop()
        Log.i(ContentValues.TAG, "onStop 실행")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(ContentValues.TAG, "onDestroy 실행")
    }
}