package com.hwangduil.imageload

import android.Manifest
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import java.io.File

class MainActivity : AppCompatActivity() {

    // 디렉터리 접근 권한
    lateinit var locationPermission: ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 갤러리 접근 허가(이거 없으면 if 블록 안에 있는게 작동이 안됨)
        locationPermission = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { results ->
            if(!results.all { it.value }) {
                Toast.makeText(this, "권한이 부여되지 않았습니다.", Toast.LENGTH_LONG).show()
            }
        }

        // 권한허가를 내줌
        locationPermission.launch(
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        )

        val imageView = findViewById<ImageView>(R.id.imageView)
        val file:File = File("/storage/emulated/0/Pictures/20220217 092642.png")
        val fExist:Boolean = file.exists()

        if(fExist) {
            Log.d("", "이미지 파일 있음")

            val myBitmap = BitmapFactory.decodeFile("/storage/emulated/0/Pictures/20220217 092642.png")
            imageView.setImageBitmap(myBitmap)
        } else {
            Log.d("", "이미지 파일 없음")
        }

    }
}