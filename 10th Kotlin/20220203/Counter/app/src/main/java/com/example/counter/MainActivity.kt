package com.example.counter

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity()/*, View.OnClickListener*/ {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number: TextView = findViewById(R.id.cntNumber)
        val incrementBtn: Button = findViewById(R.id.increment)
        val decrementBtn: Button = findViewById(R.id.decrement)
        val resetBtn: Button = findViewById(R.id.reset)

        var cnt = 0

        incrementBtn.setOnClickListener {
            cnt++
            number.text = cnt.toString()
        }

        decrementBtn.setOnClickListener {
            cnt--
            number.text = cnt.toString()
        }

        resetBtn.setOnClickListener {
            cnt = 0
            number.text = cnt.toString()
        }

        val setNumber = findViewById<EditText>(R.id.wantToSet)
        val setNumberBtn = findViewById<Button>(R.id.setNumber)

        setNumberBtn.setOnClickListener {
            if(setNumber.text != null) {
                number.text = setNumber.text
                cnt = number.text.toString().toInt()
            } else {
                AlertDialog.Builder(this@MainActivity)
                    .setTitle("잘못된 입력입니다!")
                    .setMessage("숫자가 입력되지 않아 작동할 수 없습니다. 숫자를 입력해주세요.")
                    .setCancelable(false)
                    .setNeutralButton("닫기", DialogInterface.OnClickListener {
                        _, _ ->
                    }).show()
            }
        }
    }

    /*
    override fun onClick(view: View?) {
        var number: TextView = findViewById(R.id.cntNumber)
        val incrementBtn: Button = findViewById(R.id.increment)
        val decrementBtn: Button = findViewById(R.id.decrement)
        val resetBtn: Button = findViewById(R.id.reset)
        val setNumber = findViewById<EditText>(R.id.wantToSet)
        val setNumberBtn = findViewById<Button>(R.id.setNumber)

        var cnt = 0
        incrementBtn.setOnClickListener {
            number.text = (cnt + 1).toString()
        }

        decrementBtn.setOnClickListener {
            number.text = (cnt - 1).toString()
        }

        resetBtn.setOnClickListener {
            number.text = "0"
        }

        setNumberBtn.setOnClickListener {
            number.text = setNumber.toString()
        }
    }
    */
}