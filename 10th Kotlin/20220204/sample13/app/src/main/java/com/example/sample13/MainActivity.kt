package com.example.sample13

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.example.sample13.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        setContentView(binding.root)

        registerForContextMenu(binding.textView)
    }

    // 생성한 컨텍스트 메뉴 적용
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        menuInflater.inflate(R.menu.context_menu_main, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val textView = findViewById<TextView>(R.id.textView)
        when(item.itemId) {
            R.id.text_color -> {
                textView.text = "글자색 변경"
                textView.setTextColor(Color.parseColor("#ff0000"))
            }
            R.id.text_back_color -> {
                textView.text = "배경색 변경"
                textView.setBackgroundColor(Color.parseColor("#0000ff"))
                textView.setTextColor(Color.parseColor("#ffffff"))
            }
            R.id.text_basic -> {
                textView.text = "초기화"
                textView.setTextColor(Color.parseColor("#000000"))
                textView.setBackgroundColor(Color.parseColor("#ffffff"))
            }
        }

        return super.onContextItemSelected(item)
    }
}