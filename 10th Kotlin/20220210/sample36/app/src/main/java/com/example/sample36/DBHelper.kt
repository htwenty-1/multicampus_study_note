package com.example.sample36

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int)
              : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {
        // 테이블 생성
        var sql : String = "CREATE TABLE IF NOT EXISTS TEST(" +
                           "    SEQ INTEGER PRIMARY KEY AUTOINCREMENT, " +
                           "    TXT TEXT)"

        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        var sql : String = "DROP TABLE IF EXISTS TEST"
        db?.execSQL(sql)
        onCreate(db)
    }

    fun insert(db:SQLiteDatabase, txt:String) {
        var sql = "INSERT INTO TEST(TXT)" +
                  "VALUES('${txt}')"
        db.execSQL(sql)

        /*

        */
    }
}