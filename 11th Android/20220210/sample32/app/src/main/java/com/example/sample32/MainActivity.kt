package com.example.sample32

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // JSON 파일에 접근해서 문자열을 가져와보자!
        val jsonString = assets.open("data.json").reader().readText()
        Log.d("JSON STR", jsonString)

        // JSON 파일에 접근해서 배열 형식으로 가져와보자!
        val jsonArray = JSONArray(jsonString)
        Log.d("json str", jsonArray.toString())

        val textView = findViewById<TextView>(R.id.textView)
        // JSON 파일에 접근해서 key값으로 value를 뽑아보자!
        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)

            textView.append("\n--------------------------\n")     // 경계선

            val id = jsonObject.getString("id")
            val language = jsonObject.getString("language")

            textView.append(
                """
                    $id
                """.trimIndent()
            )

            textView.append(
                """
                    $language
                """.trimIndent()
            )


        }
    }
}