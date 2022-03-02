package com.hwangduil.bbssystem.subView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hwangduil.bbssystem.R
import com.hwangduil.bbssystem.adapter.CustomAdapter
import com.hwangduil.bbssystem.dao.BbsDao
import com.hwangduil.bbssystem.dto.BbsDto

class BbsActivity : AppCompatActivity() {

    // 테스트용
//    val li = arrayListOf<BbsDto>(
//        BbsDto(1, "admin", 1, 0, 0, "테스트", "테스트글임", "2022-02-10", 0, 94),
//        BbsDto(2, "홍길동", 2, 0, 0, "test", "this is test", "2022-03-01", 0, 15),
//        BbsDto(3, "성춘향", 3, 0, 0, "テスト", "これはテストです", "2022-03-01", 0, 27)
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bbs)

        val recyclerView = findViewById<RecyclerView>(R.id.bbsRecyclerView)
        val mAdapter = CustomAdapter(this, BbsDao.getInstance().getBbsList())
        recyclerView.adapter = mAdapter

        val layout = LinearLayoutManager(this)
        recyclerView.layoutManager = layout
        recyclerView.setHasFixedSize(true)

        // 글 추가로
        val insertBtn = findViewById<Button>(R.id.bbsInsertBtn)
        insertBtn.setOnClickListener {
            val intent = Intent(this, BbsInsertActivity::class.java)
            startActivity(intent)
        }
    }
}