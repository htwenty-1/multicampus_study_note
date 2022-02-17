package recyclerAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hwangduil.photodiary.R
import dto.DataDto

class CustomAdapter(private val context: Context, val dataList:ArrayList<DataDto>) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding(dataList[position], context)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}


