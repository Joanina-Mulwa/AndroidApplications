package com.example.updatedassignment1;

import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context){
        super(context,"UserData.db", null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USER_CREDENTIALS(Username TEXT PRIMARY KEY , Password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS USER_CREDENTIALS");

    }

    //Insert OPERATION
    public boolean insertUserData(String Username, String Password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Username",Username);
        contentValues.put("Password",Password);

        long result = db.insert("USER_CREDENTIALS", null, contentValues);

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
        System.out.println(cursor.toString());
        return cursor;

    }

    public boolean verifyThisUser(String userName, String userPassword){
        SQLiteDatabase DB=this.getWritableDatabase();

        Cursor cursor=DB.rawQuery("select * from USER_CREDENTIALS where Username=? and Password=?",
                new String[]{userName, userPassword});

        System.out.println("Verify username value is = " + userName + " : Verify password is = " + userPassword);
        System.out.println("Value of Cursor is = " + cursor.getCount());

        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean deleteUserData(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from USER_CREDENTIALS where Username=?", new String[]{name});
        if(cursor.getCount()>0){
            long result = db.delete("USER_CREDENTIALS", "Username=?", new String[]{name});
            if(result == -1) return false;
            else return true;
        }
        else return false;
    }

    public void deleteUserWithName(String nameToDelete){
        Context context = null;
        if(deleteUserData(nameToDelete)){
            System.out.println(nameToDelete + " Has been deleted from the database!");
        }
        else{
            System.out.println(nameToDelete + " Has NOT been deleted from the database ERROR404!");
        }
    }

    public void printDatabaseContents(){

        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from USER_CREDENTIALS", null);
        if (cursor.moveToFirst()) {
            do {
                StringBuilder sb = new StringBuilder();
                int columnsQty = cursor.getColumnCount();
                for (int idx=0; idx<columnsQty; ++idx) {
                    sb.append(cursor.getString(idx));
                    if (idx < columnsQty - 1)
                        sb.append("; ");
                }
                Log.v(TAG, String.format("Row: %d, Values: %s", cursor.getPosition(),
                        sb.toString()));
            } while (cursor.moveToNext());
        }
    }
}
