package com.example.expenensetracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandler extends SQLiteOpenHelper {

    private static final String DB_NAME="UserInfoDB";
    private static final int DB_VERSION=1;
    private static final String TABLE_NAME="userInfo";
    private static final String ID_COL="id";
    private static final String NAME_COL="name";
    private static final String PHONE_COL="phone";
    private static final String EMAIL_COL="email";
    private static final String PASSWORD_COL="password";

    public DbHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query ="CREATE TABLE " + TABLE_NAME + "("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + PHONE_COL + " TEXT,"
                + EMAIL_COL + " TEXT,"
                + PASSWORD_COL + " TEXT" + ")";
        db.execSQL(query);
    }

    public void addNewUser(String name, String phone, String email, String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(NAME_COL,name);
        values.put(PHONE_COL,phone);
        values.put(EMAIL_COL,email);
        values.put(PASSWORD_COL,password);

        db.insert(TABLE_NAME,null,values);
        db.close();
    }


    public String getPassword(String user){
        String pass="";
        String query="SELECT PASSWORD_COL FROM " + TABLE_NAME + " WHERE EMAIL_COL=" + user;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery(query,null);
        if(c.moveToFirst()){
            do{
                pass=c.getString(0);
            }while(c.moveToNext());
        }
        c.close();
        return pass;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
