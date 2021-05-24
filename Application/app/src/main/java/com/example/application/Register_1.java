package com.example.application;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Register_1 extends BaseActivity {

    public Register_1(){}
    public String name;
    public ImageButton p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,p27,p28,p29,p30,p31,p32,p33,p34,p35,p36,p37,p38,p39,p40;
    public Button button;
    private DBHelper databaseManager;   //用于创建帮助器对象
    public Register_1(DBHelper databaseManager) {
        this.databaseManager = databaseManager;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_1);
        databaseManager = new DBHelper(this);
        Intent getintent = getIntent();
        name = getintent.getStringExtra("Name");
        p1 = findViewById(R.id.ip_1);
        p2 = findViewById(R.id.ip_2);
        p3 = findViewById(R.id.ip_3);
        p4 = findViewById(R.id.ip_4);
        p5 = findViewById(R.id.ip_5);
        p6 = findViewById(R.id.ip_6);
        p7 = findViewById(R.id.ip_7);
        p8 = findViewById(R.id.ip_8);
        p9 = findViewById(R.id.ip_9);
        p10 = findViewById(R.id.ip_10);
        p11 = findViewById(R.id.ip_11);
        p12 = findViewById(R.id.ip_12);
        p13 = findViewById(R.id.ip_13);
        p14 = findViewById(R.id.ip_14);
        p15 = findViewById(R.id.ip_15);
        p16 = findViewById(R.id.ip_16);
        p17 = findViewById(R.id.ip_17);
        p18 = findViewById(R.id.ip_18);
        p19 = findViewById(R.id.ip_19);
        p20 = findViewById(R.id.ip_20);
        p21 = findViewById(R.id.ip_21);
        p22 = findViewById(R.id.ip_22);
        p23 = findViewById(R.id.ip_23);
        p24 = findViewById(R.id.ip_24);
        p25 = findViewById(R.id.ip_25);
        p26 = findViewById(R.id.ip_26);
        p27 = findViewById(R.id.ip_27);
        p28 = findViewById(R.id.ip_28);
        p29 = findViewById(R.id.ip_29);
        p30 = findViewById(R.id.ip_30);
        p31 = findViewById(R.id.ip_31);
        p32 = findViewById(R.id.ip_32);
        p33 = findViewById(R.id.ip_33);
        p34 = findViewById(R.id.ip_34);
        p35 = findViewById(R.id.ip_35);
        p36 = findViewById(R.id.ip_36);
        p37 = findViewById(R.id.ip_37);
        p38 = findViewById(R.id.ip_38);
        p39 = findViewById(R.id.ip_39);
        p40 = findViewById(R.id.ip_40);

        p1.setOnClickListener(new ButtonListener());
        p2.setOnClickListener(new ButtonListener());
        p3.setOnClickListener(new ButtonListener());
        p4.setOnClickListener(new ButtonListener());
        p5.setOnClickListener(new ButtonListener());
        p6.setOnClickListener(new ButtonListener());
        p7.setOnClickListener(new ButtonListener());
        p8.setOnClickListener(new ButtonListener());
        p9.setOnClickListener(new ButtonListener());
        p10.setOnClickListener(new ButtonListener());
        p11.setOnClickListener(new ButtonListener());
        p12.setOnClickListener(new ButtonListener());
        p13.setOnClickListener(new ButtonListener());
        p14.setOnClickListener(new ButtonListener());
        p15.setOnClickListener(new ButtonListener());
        p16.setOnClickListener(new ButtonListener());
        p17.setOnClickListener(new ButtonListener());
        p18.setOnClickListener(new ButtonListener());
        p19.setOnClickListener(new ButtonListener());
        p20.setOnClickListener(new ButtonListener());
        p21.setOnClickListener(new ButtonListener());
        p22.setOnClickListener(new ButtonListener());
        p23.setOnClickListener(new ButtonListener());
        p24.setOnClickListener(new ButtonListener());
        p25.setOnClickListener(new ButtonListener());
        p26.setOnClickListener(new ButtonListener());
        p27.setOnClickListener(new ButtonListener());
        p28.setOnClickListener(new ButtonListener());
        p29.setOnClickListener(new ButtonListener());
        p30.setOnClickListener(new ButtonListener());
        p31.setOnClickListener(new ButtonListener());
        p32.setOnClickListener(new ButtonListener());
        p33.setOnClickListener(new ButtonListener());
        p34.setOnClickListener(new ButtonListener());
        p35.setOnClickListener(new ButtonListener());
        p36.setOnClickListener(new ButtonListener());
        p37.setOnClickListener(new ButtonListener());
        p38.setOnClickListener(new ButtonListener());
        p39.setOnClickListener(new ButtonListener());
        p40.setOnClickListener(new ButtonListener());


        button = findViewById(R.id.b_1);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                databaseManager.getReadableDatabase();
                int pic = databaseManager.pictureByName(name);
                if(pic == 0){
                    Toast toastCenter = Toast.makeText(getApplicationContext(), "未选择图片，请选择", Toast.LENGTH_SHORT);
                    toastCenter.setGravity(Gravity.CENTER, 0, 0);
                    toastCenter.show();
                }else{
                    Intent intent = null;
                    intent = new Intent(Register_1.this,Register_2.class);
                    intent.putExtra("Name", name);
                    startActivity(intent);
                }
            }
        });
    }

    private class ButtonListener implements View.OnClickListener{
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View v) {
            databaseManager.getWritableDatabase();
            switch (v.getId()) {
                case R.id.ip_1:
                    databaseManager.updatePictureByName(name, 1);
                    break;
                case R.id.ip_2:
                    databaseManager.updatePictureByName(name, 2);
                    break;
                case R.id.ip_3:
                    databaseManager.updatePictureByName(name, 3);
                    break;
                case R.id.ip_4:
                    databaseManager.updatePictureByName(name, 4);
                    break;
                case R.id.ip_5:
                    databaseManager.updatePictureByName(name, 5);
                    break;
                case R.id.ip_6:
                    databaseManager.updatePictureByName(name, 6);
                    break;
                case R.id.ip_7:
                    databaseManager.updatePictureByName(name, 7);
                    break;
                case R.id.ip_8:
                    databaseManager.updatePictureByName(name, 8);
                    break;
                case R.id.ip_9:
                    databaseManager.updatePictureByName(name, 9);
                    break;
                case R.id.ip_10:
                    databaseManager.updatePictureByName(name, 10);
                    break;
                case R.id.ip_11:
                    databaseManager.updatePictureByName(name, 11);
                    break;
                case R.id.ip_12:
                    databaseManager.updatePictureByName(name, 12);
                    break;
                case R.id.ip_13:
                    databaseManager.updatePictureByName(name, 13);
                    break;
                case R.id.ip_14:
                    databaseManager.updatePictureByName(name, 14);
                    break;
                case R.id.ip_15:
                    databaseManager.updatePictureByName(name, 15);
                    break;
                case R.id.ip_16:
                    databaseManager.updatePictureByName(name, 16);
                    break;
                case R.id.ip_17:
                    databaseManager.updatePictureByName(name, 17);
                    break;
                case R.id.ip_18:
                    databaseManager.updatePictureByName(name, 18);
                    break;
                case R.id.ip_19:
                    databaseManager.updatePictureByName(name, 19);
                    break;
                case R.id.ip_20:
                    databaseManager.updatePictureByName(name, 20);
                    break;
                case R.id.ip_21:
                    databaseManager.updatePictureByName(name, 21);
                    break;
                case R.id.ip_22:
                    databaseManager.updatePictureByName(name, 22);
                    break;
                case R.id.ip_23:
                    databaseManager.updatePictureByName(name, 23);
                    break;
                case R.id.ip_24:
                    databaseManager.updatePictureByName(name, 24);
                    break;
                case R.id.ip_25:
                    databaseManager.updatePictureByName(name, 25);
                    break;
                case R.id.ip_26:
                    databaseManager.updatePictureByName(name, 26);
                    break;
                case R.id.ip_27:
                    databaseManager.updatePictureByName(name, 27);
                    break;
                case R.id.ip_28:
                    databaseManager.updatePictureByName(name, 28);
                    break;
                case R.id.ip_29:
                    databaseManager.updatePictureByName(name, 29);
                    break;
                case R.id.ip_30:
                    databaseManager.updatePictureByName(name, 30);
                    break;
                case R.id.ip_31:
                    databaseManager.updatePictureByName(name, 31);
                    break;
                case R.id.ip_32:
                    databaseManager.updatePictureByName(name, 32);
                    break;
                case R.id.ip_33:
                    databaseManager.updatePictureByName(name, 33);
                    break;
                case R.id.ip_34:
                    databaseManager.updatePictureByName(name, 34);
                    break;
                case R.id.ip_35:
                    databaseManager.updatePictureByName(name, 35);
                    break;
                case R.id.ip_36:
                    databaseManager.updatePictureByName(name, 36);
                    break;
                case R.id.ip_37:
                    databaseManager.updatePictureByName(name, 37);
                    break;
                case R.id.ip_38:
                    databaseManager.updatePictureByName(name, 38);
                    break;
                case R.id.ip_39:
                    databaseManager.updatePictureByName(name, 39);
                    break;
                case R.id.ip_40:
                    databaseManager.updatePictureByName(name, 40);
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