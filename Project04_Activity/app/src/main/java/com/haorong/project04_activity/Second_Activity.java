package com.haorong.project04_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Second_Activity extends Activity {
    Intent intent1;
    TextView textView;
    Button btn2;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.tv);
        btn2 = findViewById(R.id.btn2);
        editText = findViewById(R.id.edit);
        //传输数据
        intent1 = getIntent();
        String data = intent1.getStringExtra("data");
        textView.setText(data);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐式启动（action、category）
                Intent intent2 = new Intent();
                String data = editText.getText().toString().trim();
                intent2.putExtra("data",data);
                intent2.setAction("com.haorong.project04_activity.Third_Activity.action");
                startActivity(intent2);
            }
        });
    }
}