package com.haorong.project01_linearlayout;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * LinearLayout：
 *     orientation：用来指定当前线性布局的方向。
 *         vertical：垂直
 *         horizontal:水平（默认）
 *     layout_width、layout_height：
 *         wrap_content：匹配内容。
 *         match_parent：匹配父View。
 *     gravity：设置View内部的对齐方式。
 *     layout_gravity：设置View在其父View中的对齐方式。
 *         left：左对齐，right：右对齐，top：上对齐，bottom：下对齐，center：居中
 *         |：组合使用。
 *         如果线性方向为水平，那么水平方向的对齐方式无效，(horizontal -- left、right都无效，center只作用在水平方向)
 *         如果线性方向为垂直，那么垂直方向的对齐方式无效。(vertical -- top、bottom都无效，center只作用在垂直方向)
 *     layout_margin:外间距
 *         layout_marginTop = "30dp"
 *     padding:内边距
 *         padding = "30dp"
 *     layout_weight：占空余空间的比例。（match_parent -- 反相关；wrap_content -- 正相关）
 */
public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView1Id);
    }

}