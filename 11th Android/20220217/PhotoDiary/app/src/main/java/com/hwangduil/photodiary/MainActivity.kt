package com.hwangduil.photodiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.hwangduil.photodiary.databinding.ActivityMainBinding
import dto.DataDto
import recyclerAdapter.CustomAdapter
import views.AddActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private val list = arrayListOf<DataDto>(
        DataDto("", "테스트", "오늘은 뭘할까?", "대전 서구 탄방동", "2021-02-17")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mAdapter = CustomAdapter(this, list)
        binding.recyclerView.adapter = mAdapter

        val layout = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layout
        binding.recyclerView.setHasFixedSize(true)

        binding.addBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            binding.addBtn -> {
                val intent = Intent(this, AddActivity::class.java)
                startActivity(intent)
            }
        }
    }
}