package com.example.minoscape;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {
    public DataBase(Context context) {
        super(context, "game.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Score(level INTEGER primary key, time TIME)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Score");
    }

    public Boolean insertData(int level, String time) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("level", level);
        contentValues.put("time", time);
        long result= DB.insert("Score", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }


    public Boolean updateData(int level, String time) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("time", time);
        Cursor cursor = DB.rawQuery("Select * from Score where level = ?", new String[]{Integer.toString(level)});
        if (cursor.getCount() > 0) {
            long result = DB.update("Score", contentValues, "level=?",new String[]{Integer.toString(level)});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
     }



    public Boolean deletedata (int level) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Score where level = ?", new String[]{Integer.toString(level)});
        if (cursor.getCount() > 0) {
            long result = DB.delete("Score", "level=?", new String[]{Integer.toString(level)});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Cursor getdata () {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Score", null);
        return cursor;

    }

    public Cursor getLevel () {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select COUNT(*) from Score", null);
        return cursor;
    }
}