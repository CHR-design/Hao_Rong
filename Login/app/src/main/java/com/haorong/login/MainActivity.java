package com.haorong.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义适配器：
 *  1、创建类继承BaseAdapter，并实现四个方法。
 *      getCount()
 *      getItem(int position)
 *      getItemId(int position)
 *      getView(int position, View convertView, ViewGroup parent)
 *  2、将xml文件转化为View对象
 *      LayoutInflater.from(MainActivity.this) -- 获取映射器对象
 *
 */
public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private List<String> list;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        lv = (ListView) findViewById(R.id.lv);
        //初始化数据源
        list = new ArrayList<String>();
        for (int i = 0; i < 40; i++) {
            list.add("数据" + i);
        }
        adapter = new MyAdapter();
        lv.setAdapter(adapter);

    }



    //实现自己的适配器
    class MyAdapter extends BaseAdapter{

        //返回数据源的长度
        @Override
        public int getCount() {
            return list.size();
        }
        //获取item对应的数据源
        @Override
        public String getItem(int position) {
            return list.get(position);
        }
        //获取item对应的id
        @Override
        public long getItemId(int position) {
            return position;
        }
        //获取item对应的视图
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View view = inflater.inflate(R.layout.my_adapter_item,null);
            TextView tv = view.findViewById(R.id.text);
            tv.setText(getText(position));
            return view;
        }
    }
}