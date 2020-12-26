package com.haorong.project06_sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class ThingActivity extends Activity {
    String sql;
    ThingOpenHelper thing;
    SQLiteDatabase database;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thing);

        thing = new ThingOpenHelper(this,"Thing.db",null,1);
        database = thing.getReadableDatabase();

        sql = "select name,phone,money from info";
        Cursor cursor = database.rawQuery(sql, null);
        while (cursor.moveToNext()){
            String name = cursor.getString(0);
            String phone = cursor.getString(1);
            int money = cursor.getInt(2);
            System.out.println(name + "," + phone+ "," + money);
        }
        Toast.makeText(this,"创建成功",Toast.LENGTH_SHORT).show();
        cursor.close();
        System.out.println("****************************");




    }
    //事务数据库
    public void transact(View view) {

        database.beginTransaction();
        try{
            sql = "update info set money = money - ? where name = ?";
            database.execSQL(sql,new Object[]{200,"alax"});
//            int i = 100/0;
            sql = "update info set money = money + ? where name = ?";
            database.execSQL(sql, new Object[]{200,"mary"});
            database.setTransactionSuccessful();

            Toast.makeText(this,"转账成功（-200）",Toast.LENGTH_SHORT).show();
            sql = "select name,phone,money from info";
            Cursor cursor2 = database.rawQuery(sql, null);
            while (cursor2.moveToNext()){
                String name = cursor2.getString(0);
                String phone = cursor2.getString(1);
                int money = cursor2.getInt(2);
                System.out.println(name + "," + phone+ "," + money);
            }
            cursor2.close();
        }catch (Exception e){
            Toast.makeText(this,"服务器忙，异常码（18876）",Toast.LENGTH_SHORT).show();
        }finally {
            database.endTransaction();
        }





    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        database.close();
    }
}
