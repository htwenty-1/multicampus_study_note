package com.example.sample36

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int)
              : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {
        // 테이블 생성
        var sql : String = " CREATE TABLE IF NOT EXISTS TEST( " +
                           "    SEQ INTEGER PRIMARY KEY AUTOINCREMENT, " +
                           "    TXT TEXT) "

        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        var sql : String = " DROP TABLE IF EXISTS TEST "
        db?.execSQL(sql)
        onCreate(db)
    }

    // CRUD
    fun insert(db:SQLiteDatabase, txt:String) {
        val sql = " INSERT INTO TEST(TXT) " +
                  " VALUES('${txt}') "
        db.execSQL(sql)
    }

    @SuppressLint("Range")
    fun read(db:SQLiteDatabase, txt: String) : String? {
        val sql = " SELECT TXT FROM TEST " +
                  " WHERE TXT = '$txt' "

        var res = db.rawQuery(sql, null)

        var str:String? = ""
        while(res.moveToNext()) {
            str += res.getString(res.getColumnIndex("SEQ")) + " " + "" + res.getString(res.getColumnIndex("TXT"))
        }

        return str
    }

    fun update(db:SQLiteDatabase, txt:String, wantToEdit:String) {
        val sql = " UPDATE TEST " +
                  " SET TXT = '$wantToEdit'" +
                  " WHERE TXT = '$txt' "
        db.execSQL(sql)
    }

    fun delete(db:SQLiteDatabase, txt:String) {
        val sql = " DELETE FROM TEST " +
                  " WHERE TXT = '$txt' "
        db.execSQL(sql)
    }
}