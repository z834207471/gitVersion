package com.example.tianan.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 瑞 on 2016/8/13.
 */
public class MyDBOpenHelper  extends SQLiteOpenHelper {

    public MyDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "MyDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS person(phonenum INTEGER PRIMARY KEY AUTOINCREMENT,email TEXT,password TEXT,name TEXT," +
                "type VARCHAR(20),are TEXT,adress TEXT,starttime TEXT,endttime TEXT,nature VARCHAR(20),cus VARCHAR(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" ALTER TABLE person ADD phone VARCHAR(12) NULL ");
    }
}

