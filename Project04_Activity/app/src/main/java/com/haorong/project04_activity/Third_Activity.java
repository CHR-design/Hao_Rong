package com.haorong.project04_activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Third_Activity extends Activity {

    String data;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button btn3 = findViewById(R.id.btn3);

        Intent intent = getIntent();
        data = intent.getStringExtra("data");

        textView = findViewById(R.id.tv);
        textView.setText(data);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //拨号效果
                takeCall(data);
            }


        });
    }
    protected void takeCall(String data) {
        Intent intent = new Intent();
        //1、拨打界面
        //Uri.parse：将字符串转化为Uri类型
        intent.setData(Uri.parse("tel:"+data));
        intent.setAction(Intent.ACTION_DIAL);
        startActivity(intent);
        //2、直接拨打电话
        //检测权限
        //checkPermission();
        //intent.setData(Uri.parse("tel:"+data));
        //intent.setAction(Intent.ACTION_CALL);//有权限则直接ACTION_CALL
        //3、发送短信
        //intent.setAction(Intent.ACTION_SENDTO);
        //intent.setData(Uri.parse("smsto:"+data));
        //4、跳转网页
//        intent.setAction(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("http://"+data));
//        startActivity(intent);
    }

    private void checkPermission() {
        //android6.0以上需要动态申请权限 sdk >= 23
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);//无权限则询问开启权限
        }
    }
}
