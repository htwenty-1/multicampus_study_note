package com.hwangduil.camera

import android.Manifest
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.FileOutputStream
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {

    // storage 권한 처리에 필요한 변수
    val CAMERA = arrayOf(Manifest.permission.CAMERA)
    val STORAGE = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    val CAMERA_CODE = 98
    val STORAGE_CODE = 99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 카메라
        val camera = findViewById<Button>(R.id.camera)
        camera.setOnClickListener {
            callCamera()
        }

        // 사진 저장
        val picture = findViewById<Button>(R.id.image)
        picture.setOnClickListener {
            getAlbumDirectory()
        }
    }

    // 카메라 사용 요청 권한
    // 카메라 권한, 저장소 권한 부여가 필요함
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            CAMERA_CODE -> {
                for (grant in grantResults) {
                    // 승인이 되어 있지 않을 때
                    if(grant != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "카메라 권한을 승인해주세요.", Toast.LENGTH_LONG).show()
                    }
                }
            }

            STORAGE_CODE -> {
                for (grant in grantResults) {
                    if(grant != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "저장소 권한을 승인해주세요.", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    // 다른 권한 확인
    fun checkPermission(permissions: Array<out String>, type: Int):Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (permission in permissions) {
                if(ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, permissions, type)
                    return false
                }
            }
        }

        return true
    }

    // 카메라 촬영을 하기 위한 함수 ==> 권한처리(checkPermission 사용)
    fun callCamera() {
        if(checkPermission(CAMERA, CAMERA_CODE) && checkPermission(STORAGE, STORAGE_CODE)) {
            val itt = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(itt, CAMERA_CODE)
        }
    }

    // 사진 저장하는 함수
    fun saveFile(fileName:String, mimeType:String, bitmap: Bitmap):Uri? {
        val CV = ContentValues()

        // MediaStore에 파일명, mimeType 지정
        CV.put(MediaStore.Images.Media.DISPLAY_NAME, fileName)
        CV.put(MediaStore.Images.Media.MIME_TYPE, mimeType)

        // 안정성 검사
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            CV.put(MediaStore.Images.Media.IS_PENDING, 1)
        }

        // MediaStore에 파일 저장
        val uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, CV)
        if(uri != null) {
            val scriptor = contentResolver.openFileDescriptor(uri, "w")
            val fos = FileOutputStream(scriptor?.fileDescriptor)

            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos)
            fos.close()

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                CV.clear()
                CV.put(MediaStore.Images.Media.IS_PENDING, 0)   // IS_PENDING을 초기화
                contentResolver.update(uri, CV, null, null)
            }
        }

        return uri
    }

    // 파일명을 날짜로 저장
    fun randomFileName():String {
        val fileName= SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis())
        return fileName
    }

    // 갤러리의 경로 취득
    fun getAlbumDirectory() {
        if(checkPermission(STORAGE, STORAGE_CODE)) {
            val itt = Intent(Intent.ACTION_PICK)
            itt.type = MediaStore.Images.Media.CONTENT_TYPE
            startActivityForResult(itt, STORAGE_CODE)
        }
    }

    // 결과
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val imageView = findViewById<ImageView>(R.id.avatars)
        if(resultCode == Activity.RESULT_OK) {
            when(requestCode) {
                CAMERA_CODE -> {
                    if(data?.extras?.get("data") != null) {
                        val img = data.extras?.get("data") as Bitmap
                        val uri = saveFile(randomFileName(), "image/png", img)
                        imageView.setImageURI(uri)
                        Toast.makeText(this, uri.toString(), Toast.LENGTH_LONG).show()
                    }
                }

                STORAGE_CODE -> {
                    val uri = data?.data
                    imageView.setImageURI(uri)
                }
            }
        }
    }
}