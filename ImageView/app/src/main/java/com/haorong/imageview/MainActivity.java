package com.haorong.imageview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button pre,next;
    private ImageView image;
    private int[] images = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.f,
            R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l};
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pre = findViewById(R.id.pre);
        next = findViewById(R.id.next);
        image = findViewById(R.id.image);

        pre.setOnClickListener(this);
        next.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //先操作，后显示
            case R.id.pre:
                count--;
                if (count < 0){
                    count = images.length - 1;
                }
                image.setImageResource(images[count]);
                break;
            case R.id.next:
                count++;
                if (count >= images.length){
                    count = 0;
                }
                image.setImageResource(images[count]);
                break;

        }
    }
}