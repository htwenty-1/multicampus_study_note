package com.hwangduil.bbssystem.subView

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.hwangduil.bbssystem.R
import com.hwangduil.bbssystem.dao.BbsDao
import com.hwangduil.bbssystem.dto.BbsDto
import com.hwangduil.bbssystem.singleton.Singleton
import java.time.LocalDate

class BbsInsertActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bbs_insert)

        val writer = findViewById<TextView>(R.id.userIdText)
        val title = findViewById<EditText>(R.id.editTitle)
        val content = findViewById<EditText>(R.id.editContent)
        val insertBtn = findViewById<Button>(R.id.insertBtn)

        writer.text = Singleton.userIdSession

        insertBtn.setOnClickListener {
            val date = LocalDate.now()
            Log.i("today", date.toString())
            var dto = BbsDto(0, writer.text.toString(), 0, 0, 0, title.text.toString(), content.text.toString(), date.toString(), 0, 0)
            BbsDao.getInstance().insertBbs(dto)

            val intent = Intent(this, BbsActivity::class.java)
            startActivity(intent)
        }
    }
}