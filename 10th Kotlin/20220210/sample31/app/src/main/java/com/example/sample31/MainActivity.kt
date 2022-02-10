package com.example.sample31

import android.os.Bundle
import android.provider.ContactsContract.Intents.Insert.NOTES
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.*
import java.lang.Exception

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val read = findViewById<Button>(R.id.read)
        val write = findViewById<Button>(R.id.write)
        val clear = findViewById<Button>(R.id.clear)

        read.setOnClickListener(this)
        write.setOnClickListener(this)
        clear.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val edit = findViewById<EditText>(R.id.editText)

        if(view?.id == R.id.read) {
            var reader:BufferedReader? = null

            try {
                val `in`: InputStream? = openFileInput(NOTES)

                if (`in` != null) {
                    reader = BufferedReader(InputStreamReader(`in`))
                    var str: String?
                    val buf = StringBuffer()

                    // 파일 읽기
                    while (reader.readLine().also { str = it } != null) {
                        println("$str")
                        buf.append("""$str""")  // 실제로 값을 읽는 위치
                    }

                    edit.setText(buf.toString())
                }
            } catch (e:FileNotFoundException) {
                // e.printStackTrace()
                println(e.message)
                println("파일을 찾을 수 없음")
            } catch (e:Exception) {
                e.printStackTrace()
                Toast.makeText(this, "exception: $e", Toast.LENGTH_SHORT).show()
            } finally {
                if(reader != null)
                    try { reader.close() }
                    catch (e:Exception) { e.printStackTrace() }
            }
        } else if (view?.id == R.id.write) {
            var out:OutputStreamWriter? = null

            try {
                // MODE_PRIVATE : 덮어쓰기, MODE_APPEND : 이어쓰기
                out = OutputStreamWriter(openFileOutput(NOTES, MODE_PRIVATE))
                out.write(edit.text.toString())     // 실제로 값을 써줌

                Toast.makeText(this, "데이터 저장", Toast.LENGTH_SHORT).show()
            } catch (e:Exception) {
                e.printStackTrace()
            } finally {
                if (out != null) try {
                    out.close()
                } catch (e:IOException) { e.printStackTrace() }
            }

        } else if (view?.id == R.id.clear) {
            edit.setText("")
        }
    }
}