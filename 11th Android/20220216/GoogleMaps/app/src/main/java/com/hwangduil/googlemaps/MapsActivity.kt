package com.hwangduil.googlemaps

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PathPermission
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.hwangduil.googlemaps.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    lateinit var locationPermission: ActivityResultLauncher<Array<String>>

    // 위치서비스가 GPS를 사용하여 위치 확인(gradle에 추가 필요)
    lateinit var fusedLocationClient:FusedLocationProviderClient

    // 위치값 요청에 대한 갱신 정보를 받는 변수
    lateinit var locationCallback:LocationCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        locationPermission = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { results ->
            if(results.all { it.value }) {
                startProcess()
            } else {    // 문제 발생 시
                Toast.makeText(this, "권한 승인이 필요합니다.", Toast.LENGTH_LONG).show()
            }
        }

        // 권한 요청
        locationPermission.launch(
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        )

    }

    fun startProcess() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)   // 상속받은 OnMapReadyCallback
    }

    // 위치정보 실시간 업데이트
    @SuppressLint("MissingPermission")
    fun updateLocation() {
        val locationRequest = LocationRequest.create()
        locationRequest.run {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            interval = 1000
        }

        locationCallback = object : LocationCallback() {
            // 1초에 한번씩 변경되는 위치정보가 onLocationResult로 전달됨
            override fun onLocationResult(locationResult: LocationResult?) {
                locationResult?.let {
                    for(location in it.locations) {
                        Log.d("위치정보 - 위도", "${location.latitude}")
                        Log.d("위치정보 - 경도", "${location.longitude}")
                        setLastLocation(location)
                    }
                }
            }
        }

        // 권한 처리
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper())
        // setLocation(37.4923219, 126.91161889999998)
    }

    fun setLastLocation(lastLocation:Location) {
        val latlng = LatLng(lastLocation.latitude, lastLocation.longitude)

        // 위도와 경도에 대한 옵션
        val makerOptions = MarkerOptions().position(latlng).title("I'm Here!")

        // 카메라 옵션
        val cameraPosition = CameraPosition.Builder().target(latlng).zoom(15.0f).build()

        mMap.clear()
        mMap.addMarker(makerOptions)
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))

    }

    // 본인이 설정한 위도, 경도로 적용하는 경우
    fun setLocation(latitude:Double, longitude:Double) {
        val latlng = LatLng(latitude, longitude)

        // 위도와 경도에 대한 옵션
        val makerOptions = MarkerOptions().position(latlng).title("I'm Here!")

        // 카메라 옵션
        val cameraPosition = CameraPosition.Builder().target(latlng).zoom(15.0f).build()

        mMap.clear()
        mMap.addMarker(makerOptions)
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        updateLocation()
    }
}