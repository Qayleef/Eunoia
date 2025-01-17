package com.example.eunoia.Mode;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MoodDB extends SQLiteOpenHelper {

    public static final String DBNAME = "MoodDB.db";

    public MoodDB(Context context) {
        super(context, "MoodDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table moodList(id INTEGER primary key autoincrement, username TEXT, emotion TEXT, subEmotion TEXT, description TEXT, date TEXT, time TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists moodList");
    }

    public Boolean insertData(String username, String emotion,String subEmotion, String description, String date, String time){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("emotion", emotion);
        contentValues.put("subEmotion",subEmotion);
        contentValues.put("description",description);
        contentValues.put("date",date);
        contentValues.put("time",time);
        long result = MyDB.insert("moodList", null, contentValues);
        if(result == -1) return false;
        else
            return true;
    }

    public Cursor viewData(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from moodList where username = ?", new String[]{username});
        return cursor;
    }
}
