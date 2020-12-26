package com.haorong.project04_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 显式启动：一般用于相同app的启动
 * 隐式启动：一般用于跳转系统app页面的启动
 *
 * 传数据：
 *      intent.putExtra("key","data");
 *
 *      多值：
 *      Bundle bundle = new Bundle();
 *      bundle.putString("key","data");
 *      intent.putExtras(bundle);
 *
 *      Intent intent = getIntent();
 *      Bundle bundle = intent.getExtras();
 *      bundle.getString("key");
 *
 * 隐式启动：
 *      传值：
 *          Data：Uri类型的唯一字段（如：tel://）
 *
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn2 = findViewById(R.id.btn1);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //显式启动
                Intent intent = new Intent(MainActivity.this,Second_Activity.class);
                intent.putExtra("data","我是第一页面的数据");
                startActivity(intent);
            }
        });

    }
}