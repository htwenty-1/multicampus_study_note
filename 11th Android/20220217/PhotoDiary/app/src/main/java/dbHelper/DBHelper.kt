package dbHelper

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import dto.DataDto
import vo.DataVo

class DBHelper(context: Context, fileName:String?) : SQLiteOpenHelper(context, fileName, null, 1) {

    // singleton
    companion object {
        var instance: DBHelper? = null
        fun getInstance(context: Context, fileName: String): DBHelper {
            if(instance == null) {
                instance = DBHelper(context, fileName)
            }
            return instance!!
        }
    }

    // SQLiteOpenHelper를 상속받아 두개의 함수 재정의
    override fun onCreate(db: SQLiteDatabase?) {
        val sql: String = " CREATE TABLE IF NOT EXISTS PHOTO_DIARY ( " +
                          " SEQ INTEGER PRIMARY KEY AUTOINCREMENT, " +
                          " FILE_PATH STRING, " +
                          " LOCATION STRING, " +
                          " TITLE STRING, " +
                          " CONTENT INTEGER, " +
                          " REG TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL) "

        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVer: Int, newVer: Int) {
        val sql = " DROP TABLE IF EXISTS PHOTO_DIARY "
        db?.execSQL(sql)
        onCreate(db)
    }

    // 내용 추가
    fun insert(dto:DataDto) {
        val sql = " INSERT INTO PHOTO_DIARY(FILE_PATH, LOCATION, TITLE, CONTENT) " +
                  " VALUES('${dto.filePath}', '${dto.location}', '${dto.title}', '${dto.content}') "

        val db = this.writableDatabase
        db.execSQL(sql)
    }

    // 내용 조회
    @SuppressLint("Range")
    fun select():ArrayList<DataVo> {
        val list = ArrayList<DataVo>()
        val sql = " SELECT * FROM PHOTO_DIARY "
        val db = this.writableDatabase

        val cursor = db.rawQuery(sql, null)

        while(cursor.moveToNext()) {
            val seq = cursor.getInt(cursor.getColumnIndex("SEQ"))
            val filePath = cursor.getString(cursor.getColumnIndex("FILE_PATH"))
            val location = cursor.getString(cursor.getColumnIndex("LOCATION"))
            val title = cursor.getString(cursor.getColumnIndex("TITLE"))
            val content = cursor.getString(cursor.getColumnIndex("CONTENT"))
            val reg = cursor.getString(cursor.getColumnIndex("REG"))

            Log.i("list", "$seq - $filePath - $location - $title - $content - $reg")

            list.add(DataVo(seq, filePath, location, title, content, reg))
        }

        cursor.close()

        return list
    }
}