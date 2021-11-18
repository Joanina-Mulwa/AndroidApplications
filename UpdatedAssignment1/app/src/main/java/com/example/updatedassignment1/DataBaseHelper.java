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
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE REGISTER_CREDENTIALS(ID INTEGER PRIMARY KEY, Fullnames TEXT, Address TEXT, Gender TEXT)");
        db.execSQL("CREATE TABLE USER_CREDENTIALS(Username TEXT PRIMARY KEY , Password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS USER_CREDENTIALS");
        db.execSQL("DROP TABLE IF EXISTS REGISTER_CREDENTIALS");

    }

    //Insert OPERATION
    public boolean insertUserData(String Username, String Password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Username",Username);
        contentValues.put("Password",Password);

        long result = db.insert("USER_CREDENTIALS", null, contentValues);

        return result != -1;
    }

    public boolean insertRegisterData(int idNumber, String fullNames, String address, String gender){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", idNumber);
        contentValues.put("Fullnames", fullNames);
        contentValues.put("Address", address);
        contentValues.put("Gender", gender);

        long result = db.insert("REGISTER_CREDENTIALS", null, contentValues);

        return result != -1;
    }

    public boolean retrieveRegisterDataForUserWithId(int idNumber){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from REGISTER_CREDENTIALS where ID="+idNumber, null);

        System.out.println("Value of Cursor when retrieving is = " + cursor.getCount());
        return cursor.getCount() > 0;
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
            return result != -1;
        }
        else return false;
    }

    public boolean deleteUserWithId(int idNumber){
        SQLiteDatabase db  = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from REGISTER_CREDENTIALS where ID=?", new String[]{String.valueOf(idNumber)});
        if(cursor.getCount()>0){
            long result = db.delete("REGISTER_CREDENTIALS", "ID=?", new String[]{String.valueOf(idNumber)});
            return result != -1;
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

    public void printDatabaseContents(String tableName){

        //Tables are USER_CREDENTIALS : REGISTER_CREDENTIALS

        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from " + tableName, null);
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
