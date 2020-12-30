package com.haorong.item_collected;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edit_username;
    private EditText edit_password;
    private LinearLayout linear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    public void init(){
        edit_username = findViewById(R.id.edit_username);
        edit_password = findViewById(R.id.edit_password);
        //隐藏输入法
        linear = findViewById(R.id.linear);
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        });
    }
    public void forget_password(View view) {
        Toast.makeText(MainActivity.this,"密码已找回",Toast.LENGTH_SHORT).show();
    }

    public void register(View view) {
        Toast.makeText(MainActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
    }

    public void login(View view) {
        if (edit_username.getText().toString().equals("123") && edit_password.getText().toString().equals("123")) {
            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
        }
//        Intent intent = new Intent(MainActivity.this,login_Activity.class);
    }
}