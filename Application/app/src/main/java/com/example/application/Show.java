package com.example.application;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

public class Show extends BaseActivity {
    public String name;
    private TextView hello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);


        Intent getintent = getIntent();
        name = getintent.getStringExtra("Name");
        hello = findViewById(R.id.hello);
        hello.setText("" + "Hello " + name);
    }
   //绑定按钮
    //重写onKeyDown方法
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //判断当点击的是返回键
        if (keyCode == event.KEYCODE_BACK) {
            exit();//退出方法
        }
        return true;
    }
    private long time = 0;
    //退出方法
    private void exit() {
//如果在两秒大于2秒
        if (System.currentTimeMillis() - time > 2000) {
//获得当前的时间
            time = System.currentTimeMillis();
            Toast.makeText(this,"再点击一次返回退出程序", Toast.LENGTH_SHORT).show();
        } else {
//点击在两秒以内
            removeALLActivity();//执行移除所以Activity方法
        }
    }
}