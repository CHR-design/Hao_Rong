package com.haorong.project05_;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


//写入的目标目录是：/data/data/包名/files/data/txt
public class SaveActivity extends Activity {

    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        button = findViewById(R.id.btn);
        editText = findViewById(R.id.edit);

        //先加载，后保存
        String load = load();
        if (!TextUtils.isEmpty(load)){
            editText.setText(load);
            Toast.makeText(this,"加载成功",Toast.LENGTH_SHORT).show();
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(editText.getText().toString());
                System.out.println(editText.getText().toString());
                Toast.makeText(SaveActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
            }
        });

    }
    public String load(){
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;
        StringBuilder stringBuilder = new StringBuilder();
        String str;
        try {
            fileInputStream = openFileInput("data.txt");
            reader = new BufferedReader(new InputStreamReader(fileInputStream));
            //需要前一次读取和后一次读取相连
            while ((str = reader.readLine())!=null){
                str = str + "\r\n";
                stringBuilder.append(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }

    public void save(String str){
        //MODE_PRIVATE：如果没有，则创建
        //MODE_APPEND：追加文本

        //写入流
        FileOutputStream fileOutputStream = null;
        //写入器
        BufferedWriter writer = null;
        try {
            fileOutputStream = openFileOutput("data.txt", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            writer.write(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
