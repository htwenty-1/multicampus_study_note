package com.hwangduil.memberspringrestful

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


//    val list = arrayListOf<MemberDto>(
//        MemberDto("kim", "kkk", "김", "kim@kim.com", 3),
//        MemberDto("lee", "lll", "이", "lee@lee.com", 3),
//        MemberDto("park", "ppp", "박", "park@park.com", 3)
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val memList = MemberDao.getInstance().allMember()
        println(memList[0].name)

        val mAdapter = CustomAdapter(this, memList)
        recyclerView.adapter = mAdapter

        val layout = LinearLayoutManager(this)
        recyclerView.layoutManager = layout
        recyclerView.setHasFixedSize(true)

    }
}