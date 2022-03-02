package com.hwangduil.bbssystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.hwangduil.bbssystem.dao.MemberDao
import com.hwangduil.bbssystem.dto.MemberDto
import com.hwangduil.bbssystem.singleton.Singleton
import com.hwangduil.bbssystem.subView.BbsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userId = findViewById<EditText>(R.id.userId)
        val userPw = findViewById<EditText>(R.id.userPwd)
        val loginBtn = findViewById<Button>(R.id.loginBtn)

        loginBtn.setOnClickListener {
            if((userId.text.toString() == "") or (userPw.text.toString() == "")) {
                Toast.makeText(this, "아이디 또는 비밀번호가 입력되지 않았습니다.", Toast.LENGTH_LONG).show()
            } else {
                val dto = MemberDto(userId.text.toString(), userPw.text.toString(), "", "", 3)
                Toast.makeText(this, "로그인 시도...", Toast.LENGTH_SHORT).show()
                MemberDao.getInstance().loginM(dto)
                Singleton.userIdSession = userId.text.toString()
                val intent = Intent(this, BbsActivity::class.java)
                startActivity(intent)
            }
        }
    }
}