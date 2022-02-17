package com.example.sample23_practice_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val frag = supportFragmentManager
        val fragTransaction = frag.beginTransaction()
        fragTransaction.add(R.id.content, FragmentMainMenu())
        fragTransaction.commit()
    }

    override fun onClick(p0: View?) {
        Log.d("button", "clicked")

        var fr:Fragment? = null

        if(p0?.id == R.id.mainBtn) {
            fr = FragmentMainMenu()
        } else if (p0?.id == R.id.subBtn) {
            fr = FragmentSubMenu()
        } else if (p0?.id == R.id.etcBtn) {
            fr = FragmentEtcMenu()
        }

        val frag = supportFragmentManager
        val fragTransaction = frag.beginTransaction()
        fragTransaction.replace(R.id.content, fr!!)
        fragTransaction.commit()
    }
}