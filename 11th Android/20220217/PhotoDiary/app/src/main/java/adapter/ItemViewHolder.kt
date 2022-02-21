package adapter

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hwangduil.photodiary.R
import vo.DataVo
import java.io.File

class ItemViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

    private val photo = itemView.findViewById<ImageView>(R.id.previewImage)
    private val title = itemView.findViewById<TextView>(R.id.viewTitle)
    private val content = itemView.findViewById<TextView>(R.id.viewContent)
    private val date = itemView.findViewById<TextView>(R.id.viewDate)

    fun binding(dataVo: DataVo, context: Context) {

        // 이미지 처리
        if(dataVo.filePath != "") {
            val resId = context.resources.getIdentifier(dataVo.filePath, "drawable", context.packageName)

            if(resId  > 0) {
                photo.setImageResource(resId)
            } else {
                val file = File(dataVo.filePath!!)
                if(file.exists()) {
                    val bitmap = BitmapFactory.decodeFile(dataVo.filePath)
                    photo.setImageBitmap(bitmap)
                } else {
                    Log.i("File", "이미지 파일이 경로('${dataVo.filePath}')에 없음")
                }
            }
        } else {
            photo.setImageResource(R.mipmap.ic_launcher_round)
        }

        // 제목, 컨텐츠, 날짜 처리
        title.text = dataVo.title
        content.text = dataVo.content
        date.text = dataVo.reg

        // 아이템뷰(항목) 클릭시
        itemView.setOnClickListener {
            Log.i("OnClick", "${dataVo.content}")


        }
    }

}