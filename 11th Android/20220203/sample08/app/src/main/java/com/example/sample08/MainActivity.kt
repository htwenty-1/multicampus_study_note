package com.example.sample08

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // action bar를 보이지 않게 해줌
//        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    // 사용자 지정 메뉴 추가
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
//        return false
    }

    // 메뉴 item 클릭시
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.i(ContentValues.TAG,"onOptionsItemSelected()가 실행됨.")

        val textView:TextView = findViewById(R.id.textView)
        when(item.itemId) {
            R.id.menu_search -> textView.text = "검색 메뉴가 클릭됨."
            R.id.menu_chat -> textView.text = "채팅 메뉴가 클릭됨."
            R.id.menu_email -> textView.text = "이메일 메뉴가 클릭됨."
            R.id.action_setting -> textView.text = "세팅 메뉴가 클릭됨."
        }
        return super.onOptionsItemSelected(item)
    }
}