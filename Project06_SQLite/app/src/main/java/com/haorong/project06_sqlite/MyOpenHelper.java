package com.haorong.project06_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyOpenHelper extends SQLiteOpenHelper {
    /**
     * @param context 上下文
     * @param name 数据库名（若为null，则在内存创建数据库，退出程序即销毁）
     * @param factory 游标工厂，使用系统默认工厂为null
     * @param version 数据库版本号
     */
    public MyOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //数据库文件第一次创建的时候，会调用该方法
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table info(_id integer primary key autoincrement, name varchar(20),phone varchar(20))");
        System.out.println("onCreate()被调用..");
    }

    //当版本号发生改变时，调用该方法
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //表结构的修改（增加字段）
        db.execSQL("alter table info add age integer");


    }

    //当降低版本时，会调用该方法
//    @Override
//    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        System.out.println("onDowngrade()被调用..");
//    }


}
