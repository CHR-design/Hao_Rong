package com.haorong.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    private ListView lv;
    ArrayAdapter<Student> adapter;
    //private String[] data = {"apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry","Mango","apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry","Mango"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //ListView初始化
        lv = (ListView) findViewById(R.id.lv);

        //适配器初始化
        /*
         * 参数一：上下文对象（一般为了确定哪个activity）
         * 参数二：子项布局的id
         * 参数三：数据源
         */
        adapter = new ArrayAdapter<Student>(this,android.R.layout.simple_list_item_1);

        //数据源初始化

        adapter.add(new Student(1,"小明","男"));
        adapter.add(new Student(2,"小亮","男"));
        adapter.add(new Student(3,"小经","男"));
        adapter.add(new Student(4,"小雪","女"));
        //配置适配器
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Student item = adapter.getItem(position);
        System.out.println("1");
        Toast.makeText(this,String.format("学号：%d，名字：%s，性别：%s",item.getId(),item.getName(),item.getSex()),Toast.LENGTH_SHORT).show();

    }
}

