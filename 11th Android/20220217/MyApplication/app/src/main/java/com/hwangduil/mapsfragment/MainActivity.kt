package com.hwangduil.mapsfragment

import android.content.Intent
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.gms.common.GooglePlayServicesUtil
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val fm = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.add(R.id.content, MapsFragment(this))   // 플래그먼트에 Map 추가
        fragmentTransaction.commit()                                        // 적용

        // 컴포넌트
        val editAddress = findViewById<EditText>(R.id.editAddress)
        val editLat = findViewById<EditText>(R.id.editLat)
        val editLon = findViewById<EditText>(R.id.editLon)
        val btn = findViewById<Button>(R.id.btn)

        val geocoder = Geocoder(this)

        btn.setOnClickListener {

            // 주소 입력하면 위도, 경도 input에 표시해주기
            var list:List<Address>? = null
            val addr = editAddress.text.toString()


            try {
                list = geocoder.getFromLocationName(addr, 10)
            } catch (e:Exception) {
                Toast.makeText(this, "잘못된 입력", Toast.LENGTH_LONG).show()
                e.printStackTrace()
            }

            if(list != null) {
                if(list.isEmpty()) {
                    Toast.makeText(this, "해당되는 주소를 찾을 수 없습니다", Toast.LENGTH_LONG).show()
                } else {
                    editLat.setText(list[0].latitude.toString())
                    editLon.setText(list[0].longitude.toString())
                }
            }
        }
    }


}