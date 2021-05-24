package com.example.application;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Register_2 extends BaseActivity {
    public Register_2() {
    }

    private ImageButton t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20;
    private Button button;
    private String name;
    private DBHelper databaseManager;   //用于创建帮助器对象
    public Register_2(DBHelper databaseManager) {
        this.databaseManager = databaseManager;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_2);
        Intent getintent = getIntent();
        name = getintent.getStringExtra("Name");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        databaseManager = new DBHelper(this);
        t1 = findViewById(R.id.t_1);
        t2 = findViewById(R.id.t_2);
        t3 = findViewById(R.id.t_3);
        t4 = findViewById(R.id.t_4);
        t5 = findViewById(R.id.t_5);
        t6 = findViewById(R.id.t_6);
        t7 = findViewById(R.id.t_7);
        t8 = findViewById(R.id.t_8);
        t9 = findViewById(R.id.t_9);
        t10 = findViewById(R.id.t_10);
        t11 = findViewById(R.id.t_11);
        t12 = findViewById(R.id.t_12);
        t13 = findViewById(R.id.t_13);
        t14 = findViewById(R.id.t_14);
        t15 = findViewById(R.id.t_15);
        t16 = findViewById(R.id.t_16);
        t17 = findViewById(R.id.t_17);
        t18 = findViewById(R.id.t_18);
        t19 = findViewById(R.id.t_19);
        t20 = findViewById(R.id.t_20);

        t1.setOnClickListener(new ButtonListener());
        t2.setOnClickListener(new ButtonListener());
        t3.setOnClickListener(new ButtonListener());
        t4.setOnClickListener(new ButtonListener());
        t5.setOnClickListener(new ButtonListener());
        t6.setOnClickListener(new ButtonListener());
        t7.setOnClickListener(new ButtonListener());
        t8.setOnClickListener(new ButtonListener());
        t9.setOnClickListener(new ButtonListener());
        t10.setOnClickListener(new ButtonListener());
        t11.setOnClickListener(new ButtonListener());
        t12.setOnClickListener(new ButtonListener());
        t13.setOnClickListener(new ButtonListener());
        t14.setOnClickListener(new ButtonListener());
        t15.setOnClickListener(new ButtonListener());
        t16.setOnClickListener(new ButtonListener());
        t17.setOnClickListener(new ButtonListener());
        t18.setOnClickListener(new ButtonListener());
        t19.setOnClickListener(new ButtonListener());
        t20.setOnClickListener(new ButtonListener());

        button = findViewById(R.id.b_2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseManager.getReadableDatabase();
                int area = databaseManager.areaByName(name);
                if(area == 0){
                    Toast toastCenter = Toast.makeText(getApplicationContext(), "未选择图片，请选择", Toast.LENGTH_SHORT);
                    toastCenter.setGravity(Gravity.CENTER, 0, 0);
                    toastCenter.show();
                }else{
                    Intent intent = null;
                    intent = new Intent(Register_2.this, Show.class);
                    intent.putExtra("Name", name);
                    startActivity(intent);
                }
            }
        });
    }

    private class ButtonListener implements View.OnClickListener {
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View v) {
            databaseManager.getWritableDatabase();
            switch (v.getId()){
                case R.id.t_1:
                    databaseManager.updateAreaByName(name, 1);
                    break;
                case R.id.t_2:
                    databaseManager.updateAreaByName(name, 2);
                    break;
                case R.id.t_3:
                    databaseManager.updateAreaByName(name, 3);
                    break;
                case R.id.t_4:
                    databaseManager.updateAreaByName(name, 4);
                    break;
                case R.id.t_5:
                    databaseManager.updateAreaByName(name, 5);
                    break;
                case R.id.t_6:
                    databaseManager.updateAreaByName(name, 6);
                    break;
                case R.id.t_7:
                    databaseManager.updateAreaByName(name, 7);
                    break;
                case R.id.t_8:
                    databaseManager.updateAreaByName(name, 8);
                    break;
                case R.id.t_9:
                    databaseManager.updateAreaByName(name, 9);
                    break;
                case R.id.t_10:
                    databaseManager.updateAreaByName(name, 10);
                    break;
                case R.id.t_11:
                    databaseManager.updateAreaByName(name, 11);
                    break;
                case R.id.t_12:
                    databaseManager.updateAreaByName(name, 12);
                    break;
                case R.id.t_13:
                    databaseManager.updateAreaByName(name, 13);
                    break;
                case R.id.t_14:
                    databaseManager.updateAreaByName(name, 14);
                    break;
                case R.id.t_15:
                    databaseManager.updateAreaByName(name, 15);
                    break;
                case R.id.t_16:
                    databaseManager.updateAreaByName(name, 16);
                    break;
                case R.id.t_17:
                    databaseManager.updateAreaByName(name, 17);
                    break;
                case R.id.t_18:
                    databaseManager.updateAreaByName(name, 18);
                    break;
                case R.id.t_19:
                    databaseManager.updateAreaByName(name, 19);
                    break;
                case R.id.t_20:
                    databaseManager.updateAreaByName(name, 20);
                    break;

            }
        }
    }

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
            Intent getintent = getIntent();
            name = getintent.getStringExtra("Name");
            databaseManager.getWritableDatabase();
            databaseManager.delete(name);
            removeALLActivity();//执行移除所以Activity方法
        }
    }
}