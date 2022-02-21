package views

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.app.Instrumentation.ActivityResult
import android.content.ContentProviderClient
import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.hwangduil.photodiary.MainActivity
import com.hwangduil.photodiary.databinding.ActivityAddBinding
import dbHelper.DBHelper
import dto.DataDto
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat

class AddActivity : AppCompatActivity(), View.OnClickListener {

    // binding을 통해 컴포넌트에 자유롭게 접근함.
    private lateinit var binding:ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 권한 부여
        locationPermission = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()) { results ->
            if(!results.all{it.value}) {
                Toast.makeText(this, "권한이 부여되지 않음", Toast.LENGTH_LONG).show()
            }
        }

        locationPermission.launch(
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        )

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        updateLocation()

        // 상속받은 OnClickListener 적용
        binding.addInitBtn.setOnClickListener(this)
        binding.takePictureBtn.setOnClickListener(this)
    }

    // 상속받은 OnClickListener 구현
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

            // 저장 버튼
            binding.addSaveBtn -> {
                Log.d("OnClick", "save 버튼 클릭")

                val addr = getAddress(latitude, longitude)

                DBHelper.getInstance(this, "photo_diary.db")
                        .insert(DataDto(0,
                                        binding.imgPathText.text.toString(),
                                        addr,
                                        binding.addEditTitle.text.toString(),
                                        binding.addEditContent.text.toString(),
                                        ""))

                Toast.makeText(this, "저장아 완료되었습니다!", Toast.LENGTH_LONG).show()

                val itt = Intent(this, MainActivity::class.java)
                startActivity(itt)
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
1
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

    // 위치 정보에 관한 권한 처리
    lateinit var locationPermission: ActivityResultLauncher<Array<String>>
    lateinit var fusedLocationClient: FusedLocationProviderClient
    lateinit var locationCallback: LocationCallback

    var latitude:Double = 0.0
    var longitude:Double = 0.0

    fun getAddress(lat:Double, lon:Double):String {
        val geocoder = Geocoder(this)
        var list: List<Address>? = null
        var address = ""

        try {
            list = geocoder.getFromLocation(lat, lon, 10)
        } catch (e: IOException) {
            e.printStackTrace()
            Log.i("test", "입출력 확인할 것")
        }

        if(list != null) {
            if(list.isEmpty()) {
                AlertDialog.Builder(this@AddActivity)
                    .setTitle("내용을 확인해주세요.")
                    .setMessage("해당 주소는 존재하지 않습니다.")
                    .setCancelable(false)
                    .setNeutralButton("닫기", { dialog, whick -> }).show()
            } else {
                address = list[0].getAddressLine(0).toString()
            }
        }

        return address
    }

    fun updateLocation() {
        val locationRequest = LocationRequest.create()

        // 1초마다 정확한 위치정보 갱신
        locationRequest.run {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            interval = 1000
        }

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                locationResult?.let {
                    for(location in it.locations) {
                        latitude = location.latitude
                        longitude = location.longitude
                    }
                }
            }
        }

        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper())
    }
}