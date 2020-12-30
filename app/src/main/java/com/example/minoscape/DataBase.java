package com.example.minoscape;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {

    /* Cette classe correspond à la création de notre base de donnée */

    public DataBase(Context context) {
        super(context, "game.db", null, 1);
    }

    /** Création de la table Score
     * @param DB
     **/
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Score(level INTEGER primary key, time TIME, difficulty TEXT)");
    }

    /** Suppression de la table score si elle existe
     * @param DB
     * @param i
     * @param i1
     **/
    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Score");
    }

    /** Création de la requête d'insertion
     * @param level
     * @param time
     * @param difficulty
     **/
    public Boolean insertData(int level, String time, String difficulty) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("level", level);
        contentValues.put("time", time);
        contentValues.put("difficulty", difficulty);
        long result= DB.insert("Score", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    /** Requête qui permet de sélectionner les scores contenues dans la base de donnée **/
    public Cursor getdata () {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Score", null);
        return cursor;
    }

    /** Requête sélectionnant les 3 meilleurs scores **/
    public Cursor getTop3 () {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Score order by time asc limit 3", null);
        return cursor;
    }
}
