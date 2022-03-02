package com.hwangduil.bbssystem.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hwangduil.bbssystem.R
import com.hwangduil.bbssystem.dto.BbsDto

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title = itemView.findViewById<TextView>(R.id.viewTitle)
    val writer = itemView.findViewById<TextView>(R.id.viewUser)
    val counter = itemView.findViewById<TextView>(R.id.viewCounter)

    @SuppressLint("SetTextI18n")
    fun bind(dto:BbsDto, context: Context) {
        title.text = dto.title
        writer.text = dto.id
        counter.text = "조회수 ${dto.readCount}"
    }
}