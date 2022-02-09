package com.example.sample30

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class ProfileDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_detail)

        // getAttribute
        val data = intent.getParcelableExtra<DataVo>("data")
        // println(data?.name + " " + data?.id)

        val imgViewer = findViewById<ImageView>(R.id.img_profile)
        val userName = findViewById<TextView>(R.id.userName)
        val userId = findViewById<TextView>(R.id.userId)
        val userPay = findViewById<TextView>(R.id.userPay)

        // 모든 데이터가 문자열로 넘어오기 때문에 이미지 데이터를 설정하는데 곤란함이 있다면..
        // imgViewer.setImageResource(R.drawable.XXX)는 사용할 수 없다!!
        Glide.with(this).load(getImage(data?.photo)).into(imgViewer)

        userId.text = data?.id
        userName.text = data?.name
        userPay.text = data?.pay.toString()
    }

    fun getImage(imageName:String?) : Int {
        return resources.getIdentifier(imageName, "drawable", packageName)
    }

}