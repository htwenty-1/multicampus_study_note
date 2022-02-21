package com.hwangduil.photodiary

import adapter.CustomAdapter
import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.hwangduil.photodiary.databinding.ActivityMainBinding
import dbHelper.DBHelper
import dto.DataDto
import views.AddActivity
import vo.DataVo

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var locationPermission: ActivityResultLauncher<Array<String>>

//    private val list = arrayListOf<DataVo>(
//        DataVo(0, "/storage/emulated/0/Pictures/2022-02-16 10_42_44.png", "대전시", "테스트 제목1", "테스트 내용1", "11"),
//
//        DataVo(1, "/storage/emulated/0/Pictures/2022-02-16 10_47_43.png", "대전시", "테스트 제목2", "테스트 내용2", "12")
//
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = DBHelper.getInstance(this, "photo_diary.db").select()

        val mAdapter = CustomAdapter(this, list)
        binding.recyclerView.adapter = mAdapter

        val layout = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layout
        binding.recyclerView.setHasFixedSize(true)

        binding.addBtn.setOnClickListener(this)

        locationPermission = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { results ->
            if(!results.all{ it.value }) {
                Toast.makeText(this, "권한이 부여되지 않았습니다.", Toast.LENGTH_LONG).show()
            }
        }

        locationPermission.launch(
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        )

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