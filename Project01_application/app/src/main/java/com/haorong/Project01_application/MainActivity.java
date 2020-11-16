package com.haorong.Project01_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    Button button;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView1Id);
        button = findViewById(R.id.button1Id);

        ButtonListener buttonListener = new ButtonListener();
        button.setOnClickListener(buttonListener);
    }
    class ButtonListener implements OnClickListener{

        @Override
        public void onClick(View v) {
            count++;
            textView.setText("点我"+count+"下");
        }
    }
}