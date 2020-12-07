package com.haorong.myadapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * 存在弊端：不断的占用内存不断的setContentView()，并重新加载数据
 */
public class CustomListView extends Activity implements OnItemClickListener {
    private ListView lv;
    //数据初始化
    private int[] images = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a1, R.drawable.a2, R.drawable.a3};
    private String[] name = {"机", "李", "父", "机", "李", "父", "机", "李", "父", "机", "李", "父"};
    private String[] dec = {"机为尾", "李为中", "父为先", "机为尾", "李为中", "父为先", "机为尾", "李为中", "父为先", "机为尾", "李为中", "父为先"};
    private Custom[] data = new Custom[name.length];

    private static int p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_listview);
        for (int i = 0; i < name.length; i++) {
            data[i] = new Custom(images[i], name[i], dec[i]);
        }
        //配置数据
        MyAdapter adapter = new MyAdapter(this, data);
        lv = findViewById(R.id.lv);

        lv.setAdapter(adapter);
        //实现监听事件(存在弊端：不断的占用内存不断的setContentView()，并重新加载数据)
        lv.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        p = position;
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
    }

    public static int getPosition() {
        return p;
    }

    public int[] getImages() {
        return images;
    }
}
