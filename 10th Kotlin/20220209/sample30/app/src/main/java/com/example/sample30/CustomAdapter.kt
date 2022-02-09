package com.example.sample30

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ItemViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
    private val userPhoto = itemView.findViewById<ImageView>(R.id.img_profile)
    private val userName = itemView.findViewById<TextView>(R.id.userNameText)
    private val userPay = itemView.findViewById<TextView>(R.id.payText)
    private val userAddress = itemView.findViewById<TextView>(R.id.addressText)

    // data를 resource로 옮겨주는 작업 === binding
    fun bind(dataVo: DataVo, context: Context) {
        // Image(image)
        if(dataVo.photo != "") {
            val resourceId = context.resources.getIdentifier(dataVo.photo, "drawable", context.packageName)

            if (resourceId > 0) {
                userPhoto.setImageResource(resourceId)
            } else {
                // 이미지가 제대로 넘어오지 못했을 때 재로딩해서 아이템을 받아줌
                Glide.with(itemView).load(dataVo.photo).into(userPhoto)
            }
        } else {
            // 이미지가 없는 경우 지원되는 아무 이미지나 뿌릴 수 있게 함.
            userPhoto.setImageResource(R.mipmap.ic_launcher_round)
        }

        // TextView에 데이터 세팅(String)
        userName.text = dataVo.name
        userPay.text = dataVo.pay.toString()
        userAddress.text = dataVo.address

    }

}

class CustomAdapter(private val context:Context, private val dataList:ArrayList<DataVo>) : RecyclerView.Adapter<ItemViewHolder>() {


}

