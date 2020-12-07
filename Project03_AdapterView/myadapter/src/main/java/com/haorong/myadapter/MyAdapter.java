package com.haorong.myadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private Custom[] data;
    public MyAdapter(Context context,Custom[] data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Custom getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout ll = null;
        //滑动：获取convertView回收
        if(convertView!=null){
            ll = (LinearLayout) convertView;
        }else{//未滑动：创建Item布局
            ll = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.custom_list,null);
        }
        //获取当前Item数据
        Custom data = getItem(position);
        ImageView image = ll.findViewById(R.id.image);
        TextView name = ll.findViewById(R.id.name);
        TextView dec = ll.findViewById(R.id.dec);

        image.setImageResource(data.getImage());
        name.setText(data.getName());
        dec.setText(data.getDec());
        return ll;
    }
}
