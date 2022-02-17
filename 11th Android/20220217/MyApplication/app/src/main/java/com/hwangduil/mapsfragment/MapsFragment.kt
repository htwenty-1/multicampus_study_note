package com.hwangduil.mapsfragment

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.location.Location
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

class MapsFragment(var activity: Activity) : Fragment(), OnMapReadyCallback {

    /*private val callback = OnMapReadyCallback { googleMap ->
        val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }*/

    // 위치정보 권한추가
    lateinit var locationPermission: ActivityResultLauncher<Array<String>>

    private lateinit var mMap: GoogleMap

    // 위치서비스가 GPS를 사용하여 위치 확인(gradle에 추가 필요)
    lateinit var fusedLocationClient: FusedLocationProviderClient

    // 위치값 요청에 대한 갱신 정보를 받는 변수
    lateinit var locationCallback: LocationCallback

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // 권한 승인
        locationPermission = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { results ->
            if(!results.all { it.value }) {
                Toast.makeText(activity, "권한 승인이 필요합니다.", Toast.LENGTH_LONG).show()
            }
        }

        // 권한 요청
        locationPermission.launch(
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        )

        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap!!
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity)
        updateLocation()
    }

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

    }

    fun setLastLocation(lastLocation: Location) {
        val latlng = LatLng(lastLocation.latitude, lastLocation.longitude)

        // 위도와 경도에 대한 옵션
        val makerOptions = MarkerOptions().position(latlng).title("I'm Here!")

        // 카메라 옵션
        val cameraPosition = CameraPosition.Builder().target(latlng).zoom(15.0f).build()

        mMap.clear()
        mMap.addMarker(makerOptions)
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }

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
}