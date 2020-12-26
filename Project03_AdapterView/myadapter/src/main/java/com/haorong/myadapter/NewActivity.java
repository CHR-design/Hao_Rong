package com.haorong.myadapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class NewActivity extends Activity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_image);
        
        Intent intent = getIntent();
        int position = intent.getIntExtra("position",-1);
        if(position != -1){
            ImageView image = findViewById(R.id.icon);
            image.setImageResource(CustomListView.getImages()[position]);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG","onDestroy方法被执行");
    }
}
