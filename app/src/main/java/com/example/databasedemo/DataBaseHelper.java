package com.example.databasedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String TAG ="DataBaseHelper" ;

    /**
     *
     * @param context 上下文
     */
    public DataBaseHelper(@Nullable Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.VERSION_CODE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //创建时的回调
        Log.d(TAG, "创建数据库...");
        //创建字段
        String sql="create table "+Constants.TABLE_NAME+"(_id integer,name varchar,age integer,salary integer)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         //升级时的回调
        Log.d(TAG,"升级数据库...");
        String sql;
        switch (oldVersion){
            case 1:
                sql="alter table "+Constants.TABLE_NAME+" add phone integer";
                db.execSQL(sql);
                break;
            case 2:
                //sql: alter table table_name add phone integer;
                sql="alter table "+Constants.TABLE_NAME+" add address varchar";
                db.execSQL(sql);
                break;
            case 3:

                break;
        }
    }
}
