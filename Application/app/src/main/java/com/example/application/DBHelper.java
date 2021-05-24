package com.example.application;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
    private SQLiteDatabase db;
    public DBHelper(Context context){
        super(context, "db_test", null, 1);
        db = getReadableDatabase();
    }

    private static final String USER = "user";
    private static final String NAME = "name";
    private static final String PICTURE = "picture";
    private static final String AREA = "area";

    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table USER(NAME string, PICTURE integer, AREA integer)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table if exists " + USER);
    }

    public void add(String name, int picture, int area){
        db.execSQL("INSERT INTO USER(NAME, PICTURE, AREA) VALUES( ?,?,? )", new Object[]{name,picture,area});
    }

    public void updatePictureByName(String name, int picture){
        db = this.getWritableDatabase();
        String sqlUpdate = "update " + USER +" set " + PICTURE + " = " + picture  + " where " + NAME + " = '" + name + "'";
        db.execSQL(sqlUpdate);
    }

    public void updateAreaByName(String name, int area){
        db = this.getWritableDatabase();
        String sqlUpdate = "update " + USER +" set " + AREA + " = " + area  + " where " + NAME + " = '" + name + "'";
        db.execSQL(sqlUpdate);
    }

    public int checkByName(String name){
        Cursor cursor = db.query(USER, null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            do{
                String namecheck = cursor.getString(cursor.getColumnIndex("NAME"));
                if(namecheck.equals(name)){
                    return 1;
                }
            }while (cursor.moveToNext());
        }
        return 0;
    }

    public int pictureByName(String name){
        int picture;
        Cursor cursor = db.query(USER, null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            do{
                String namecheck = cursor.getString(cursor.getColumnIndex("NAME"));
                if(namecheck.equals(name)){
                    picture = cursor.getInt(cursor.getColumnIndex("PICTURE"));
                    return picture;
                }
            }while (cursor.moveToNext());
        }
        return 0;
    }

    public int areaByName(String name){
        int area;
        Cursor cursor = db.query(USER, null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            do{
                String namecheck = cursor.getString(cursor.getColumnIndex("NAME"));
                if(namecheck.equals(name)){
                    area = cursor.getInt(cursor.getColumnIndex("AREA"));
                    return area;
                }
            }while (cursor.moveToNext());
        }
        return 0;
    }

    public void delete(String name){
        db = this.getWritableDatabase();
        String sqlDelete = "delete from " + USER +" where " + NAME + " = '" + name + "'";
        db.execSQL(sqlDelete);
    }
}