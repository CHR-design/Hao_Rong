package com.haorong.project06_sqlite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * SQLite
 *  优点：
 *      1、轻
 *      2、绿色
 *      3、跨平台
 *      4、单一文件
 *  缺点：
 *      1、多线程操作较为差劲
 *      2、对sql的支持不全面（可以删除原表，将数据移到新表）
 *
 *  getReadableDatabase
 *  getWritableDatabase
 *  大部分都是一样的，获取可读可写的数据库
 *     不同：
 *       getReadableDatabase：在磁盘满时，会返回一个只读的数据库
 *       getWritableDatabase：在磁盘满时，会出错
 *
 */

public class MainActivity extends AppCompatActivity {
    private Button insert;
    private Button delete;
    private Button update;
    private Button query;
    private MyOpenHelper openHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert = findViewById(R.id.insert1);
        delete = findViewById(R.id.delete1);
        update = findViewById(R.id.update1);
        query = findViewById(R.id.query1);


        openHelper = new MyOpenHelper(this,"MySQLite.db",null,2);



    }

    public void insert(View view){
        SQLiteDatabase database = openHelper.getReadableDatabase();
        String sql = "insert into info (name,phone,age) values('zhangsan','1388888888',30)";
        database.execSQL(sql);
        sql = "insert into info (name,phone,age) values('lisi','1399999999',30)";
        database.execSQL(sql);
        Toast.makeText(this,"插入成功",Toast.LENGTH_SHORT).show();
        database.close();
    }

    public void delete(View view){
        SQLiteDatabase database = openHelper.getReadableDatabase();
        String sql = "delete from info where name = 'lisi'";
        database.execSQL(sql);
        Toast.makeText(this,"删除成功",Toast.LENGTH_SHORT).show();
        database.close();
    }

    public void update(View view){
        SQLiteDatabase database = openHelper.getReadableDatabase();
        String sql = "update info set phone = 1300000000 where name = 'zhangsan'";
        database.execSQL(sql);
        Toast.makeText(this,"修改成功",Toast.LENGTH_SHORT).show();
        database.close();
    }

    public void query(View view){
        SQLiteDatabase database = openHelper.getReadableDatabase();
        String sql = "select * from info";
        Cursor cursor = database.rawQuery(sql, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            int age = cursor.getInt(3);
            System.out.println(id+","+name+","+phone+","+age);
        }
        Toast.makeText(this,"查询成功",Toast.LENGTH_SHORT).show();

        cursor.close();
        database.close();
    }



    public void insert1(View view){
        SQLiteDatabase database = openHelper.getReadableDatabase();
//        String sql = "insert into info (name,phone,age) values('zhangsan','1388888888',30)";
        ContentValues values = new ContentValues();
        values.put("name","alax");
        values.put("phone","13777777777");
        values.put("age",30);
        long id = database.insert("info", "name", values);
        if (id != -1){
            Toast.makeText(this, "当前插入到第"+id+"行", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "插入失败", Toast.LENGTH_SHORT).show();
        }
        query(insert);
        database.close();
    }

    public void delete1(View view){
        SQLiteDatabase database = openHelper.getReadableDatabase();

        String table = "info";
        String whereClause = "name = ?";
        String[] whereArgs = {"alax"};
        int id = database.delete(table, whereClause, whereArgs);

        if (id != 0){
            Toast.makeText(this, "删除了"+id+"行数据", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "删除失败", Toast.LENGTH_SHORT).show();
        }
        query(delete);
        database.close();
    }

    public void update1(View view){
        SQLiteDatabase database = openHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("phone","110");
        int id = database.update("info", values, "name = ?", new String[]{"zhangsan"});
        if (id != 0){
            Toast.makeText(this, "修改了"+id+"行数据", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "修改失败", Toast.LENGTH_SHORT).show();
        }
        query(delete);
        database.close();
    }

    public void query1(View view){
        SQLiteDatabase database = openHelper.getReadableDatabase();
        Cursor cursor = database.query("info", new String[]{"*"},"name = ?",new String[]{"zhangsan"},null,null,null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            int age = cursor.getInt(3);
            System.out.println(id+","+name+","+phone+","+age);
        }
        Toast.makeText(this,"查询成功",Toast.LENGTH_SHORT).show();

        cursor.close();
        database.close();
    }

    public void thing(View view) {


        Intent intent = new Intent(MainActivity.this,ThingActivity.class);
        intent.setAction("");
        startActivity(intent);
    }
}