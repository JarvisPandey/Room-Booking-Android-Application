package com.example.shubhampandey.bookmyroom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="rooms.db";

    public static String TABLE_NAME="room_table";


    public database(Context context) {
        super(context,DATABASE_NAME,null,1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT,PLACE TEXT,BHK INTEGER,RENT INTEGER,PHONE_N0 INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

        onCreate(db);

    }

    public boolean insertData(String place, int rooms,int rent,int phone){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues= new ContentValues();
        contentValues.put("PLACE",place);
        contentValues.put("BHK",rooms);
        contentValues.put("RENT",rent);
        contentValues.put("PHONE_NO",phone);

        long result=db.insert(TABLE_NAME,null,contentValues);

        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
}
