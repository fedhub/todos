package com.example.swisa.todosapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.swisa.todosapp.TableTask.TableInfo;

/**
 * Created by swisa on 12/12/2015.
 */


public class DatabaseOperations extends SQLiteOpenHelper {

    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE " + TableInfo.TABLE_NAME + "(" + TableInfo.TITLE + " TEXT," + TableInfo.DONE + " INTEGER);";

    public DatabaseOperations(Context context){
        super(context, TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database operations", "Database Created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void putInformation(DatabaseOperations dop, String title, boolean done){
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableInfo.TITLE, title);
        cv.put(TableInfo.DONE, done);
        long k = SQ.insert(TableInfo.TABLE_NAME, null, cv);
        Log.d("Database operations", "One row inserted");
    }

    public Cursor getInformation(DatabaseOperations dop){
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] columns = {TableInfo.TITLE, TableInfo.DONE};
        return SQ.query(TableInfo.TABLE_NAME, columns, null, null, null, null, null);
    }

    public void deleteTask(DatabaseOperations dop){
        SQLiteDatabase SQ = dop.getWritableDatabase();
        SQ.execSQL("delete from " + TableInfo.TABLE_NAME);
    }
}
