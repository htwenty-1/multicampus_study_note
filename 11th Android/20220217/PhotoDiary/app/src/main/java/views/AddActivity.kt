package views

import android.Manifest
import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.hwangduil.photodiary.databinding.ActivityAddBinding
import java.io.FileOutputStream
import java.text.SimpleDateFormat

class AddActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding:ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addInitBtn.setOnClickListener(this)
        binding.takePictureBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            // 다시 쓰기 버튼
            binding.addInitBtn -> {
                binding.addImgView.setImageResource(0)
                binding.addEditTitle.setText("")
                binding.addEditContent.setText("")
                binding.imgPathText.text = "사진의 경로가 표시됩니다."
            }

            // 사진 촬영 버튼
            binding.takePictureBtn -> {
                callCamera()
            }

            binding.saveBtn -> {

            }
        }
    }

    // 카메라 및 스토리지 사용을 위한 변수 선언
    private val CAMERA = arrayOf(Manifest.permission.CAMERA)
    private val STORAGE = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    private val CAMERA_CODE = 98
    private val STORAGE_CODE = 99

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode) {
            CAMERA_CODE -> {
                for(grant in grantResults) {
                    if(grant != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "카메라 권한을 승인해 주세요.", Toast.LENGTH_LONG).show()
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

    fun callCamera() {
        if(checkPermission(CAMERA, CAMERA_CODE) && checkPermission(STORAGE, STORAGE_CODE)) {
            val itt = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(itt, CAMERA_CODE)
        }
    }

    fun saveFile(fileName:String, mimeType:String, bitmap: Bitmap): Uri? {
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

    fun randomFileName():String {
        val fileName= SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())
        return fileName
    }

    fun getPath(uri: Uri?): String {
        val projection = arrayOf<String>(MediaStore.Images.Media.DATA)
        val cursor: Cursor = managedQuery(uri, projection, null, null, null)
        startManagingCursor(cursor)
        val columnIndex: Int = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor.moveToFirst()
        return cursor.getString(columnIndex)
    }

    fun getAlbumDirectory() {
        if(checkPermission(STORAGE, STORAGE_CODE)) {
            val itt = Intent(Intent.ACTION_PICK)
            itt.type = MediaStore.Images.Media.CONTENT_TYPE
            startActivityForResult(itt, STORAGE_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK) {
            when(requestCode) {
                CAMERA_CODE -> {
                    if(data?.extras?.get("data") != null) {
                        val img = data.extras?.get("data") as Bitmap
                        val uri = saveFile(randomFileName(), "image/png", img)
                        binding.addImgView.setImageURI(uri)
                        binding.imgPathText.text = getPath(uri)
                    }
                }

                STORAGE_CODE -> {
                    val uri = data?.data
                    binding.addImgView.setImageURI(uri)
                }
            }
        }
    }

}