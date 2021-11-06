package com.example.updatedassignment1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context){
        super(context,"UserData.db", null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USER_CREDENTIALS (Username TEXT PRIMARY KEY , Password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS USER_CREDENTIALS");

    }

    //Insert OPERATION
    public boolean insertUserData(String Username, String Password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("keyUserName",Username);
        contentValues.put("keyUserName",Password);

        long result = db.insert("User_Credentials", null, contentValues);

        if (result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public Cursor getData(){
        SQLiteDatabase DB=this.getWritableDatabase();

        Cursor cursor=DB.rawQuery("Select * from USER_CREDENTIALS", null);
        return cursor;

    }
}
