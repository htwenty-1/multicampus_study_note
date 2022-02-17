package recyclerAdapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hwangduil.photodiary.R
import dto.DataDto

class ItemViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val photo = itemView.findViewById<ImageView>(R.id.previewImage)
    private val title = itemView.findViewById<TextView>(R.id.viewTitle)
    private val content = itemView.findViewById<TextView>(R.id.viewContent)
    private val date = itemView.findViewById<TextView>(R.id.viewDate)

    fun binding(dataDto: DataDto, context: Context) {
        if(dataDto.imagePath != "") {
            val resId = context.resources.getIdentifier(dataDto.imagePath, "", context.packageName)

            if(resId > 0) {
                photo.setImageResource(resId)
            } else {
                Glide.with(itemView).load(dataDto.imagePath).into(photo)
            }
        } else {
            photo.setImageResource(R.mipmap.ic_launcher)
        }

        title.text = dataDto.title
        content.text = dataDto.content
        date.text = dataDto.date

        // 리사이클러뷰 각 아이템 클릭시
        itemView.setOnClickListener {  }
    }

}