package com.hwangduil.geocoding

import android.annotation.SuppressLint
import android.content.Intent
import android.location.Address
import android.location.Geocoder
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.io.IOException

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val addrBtn = findViewById<Button>(R.id.addrBtn)
        val mapBtn1 = findViewById<Button>(R.id.mapBtn1)
        val latBtn = findViewById<Button>(R.id.latBtn)
        val mapBtn2 = findViewById<Button>(R.id.mapBtn2)
        val addrEdit = findViewById<EditText>(R.id.addrText)

        val latEdit = findViewById<EditText>(R.id.latText)
        val lonEdit = findViewById<EditText>(R.id.lonText)

        val geocoder:Geocoder = Geocoder(this)

        // 변환 : 위도, 경도 입력시 주소반환
        addrBtn.setOnClickListener {
            var list: List<Address>? = null

            try {
                val d1: Double = latEdit.text.toString().toDouble()
                val d2: Double = lonEdit.text.toString().toDouble()

                list = geocoder.getFromLocation(d1, d2, 10)
            } catch (e:IOException) {
                Log.d("위도/경도", "입출력 오류")
            }

            if (list != null) {
                if(list.isEmpty()) {
                    textView.text = "해당되는 주소는 없습니다."
                } else {
                    textView.text = list[0].toString()
                }
            }
        }

        mapBtn1.setOnClickListener {
            val d1: Double = latEdit.text.toString().toDouble()
            val d2: Double = lonEdit.text.toString().toDouble()

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:$d1,$d2"))
            startActivity(intent)
        }

        // 주소 -> 위도와 경도
        latBtn.setOnClickListener {
            var list:List<Address>? = null
            var str = addrEdit.text.toString()

            try {
                list = geocoder.getFromLocationName(str, 10)
            } catch (e:IOException) {
                Log.d("위도/경도", "입출력 오류")
            }

            if (list != null) {
                if(list!!.isEmpty()) {
                    textView.text = "해당되는 주소는 없습니다."
                } else {
                    // textView.text = list!![0].toString()
                    textView.text = list!![0].latitude.toString() + " " + list!![0].longitude.toString()
                }
            }
        }

        mapBtn2.setOnClickListener {
            var list:List<Address>? = null

            var str = addrEdit.text.toString()
            try {
                list = geocoder.getFromLocationName(str, 10)
            } catch (e:IOException) {
                Log.d("위도/경도", "입출력 오류")
            }

            if(list != null) {
                if(list!!.isEmpty()) {
                    textView.text = "해당되는 주소는 없습니다."
                } else {
                    val addr = list!![0]
                    val lat = addr.latitude
                    val lon = addr.longitude
                    val geo = String.format("geo:%f,%f", lat, lon)
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(geo))
                    startActivity(intent)
                }
            }
        }

    }
}