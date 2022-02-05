package com.example.databasedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Dao {
    private static final String TAG ="Dao" ;
    private final DataBaseHelper mHelper ;

    //    数据库的增删改查
    public Dao(Context context){
        //创建数据库
//        ctrl+alt+f 改为全局变量
        mHelper= new DataBaseHelper(context);

    }

    public void insert(){
        SQLiteDatabase db=mHelper.getWritableDatabase();
//        String sql="insert into "+Constants.TABLE_NAME+"(_id,name,age,salary,phone,address) values(?,?,?,?,?,?)";
//        db.execSQL(sql,new Object[]{1,"BillGates",60,1,110,"USA"});


        ContentValues values=new ContentValues();
        //添加数据
        values.put("_id",2);
        values.put("name","liaojie");
        values.put("salary",1);
        values.put("phone",1290);
        values.put("address","China");
        values.put("age",19);
        db.insert(Constants.TABLE_NAME,null,values);


        db.close();
    }
    public void delete(){
        SQLiteDatabase db=mHelper.getWritableDatabase();
//        String sql="delete from "+Constants.TABLE_NAME+ " where age = 60";
//        db.execSQL(sql);

        int result=db.delete(Constants.TABLE_NAME,null,null);
        Log.d(TAG, "delete result=="+result);
        db.close();

    }
    public void update(){
        SQLiteDatabase db=mHelper.getWritableDatabase();
//        String sql="update "+Constants.TABLE_NAME+ " set salary = 2 where age = 60";
//        db.execSQL(sql);


        ContentValues values=new ContentValues();
        values.put("phone",123456789);
        db.update(Constants.TABLE_NAME,values,null,null);
        db.close();

    }
    public void query(){
        SQLiteDatabase db=mHelper.getWritableDatabase();
//        String sql="select * from "+Constants.TABLE_NAME;
//        Cursor cursor=db.rawQuery(sql,null);
//
//        while (cursor.moveToNext()) {
//            int index=cursor.getColumnIndex("name");
//            String name=cursor.getString(index);
//            Log.d(TAG, "name=="+name);
//        }
//        cursor.close();

       Cursor cursor= db.query(Constants.TABLE_NAME,null,null,null,null,null,null);
        while (cursor.moveToNext()){

            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            Log.d(TAG, "id=="+id+"name=="+name);
        }
       cursor.close();
       db.close();

    }
}
