package com.example.application;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Login_1 extends BaseActivity {
    public Login_1(){}

    private TextView lt;
    public ImageView bt;
    private Button button;
    private int[] textNum;
    private int[] imageNum;
    private int[] user_site;
    private String username;

    private DBHelper databaseManager;   //用于创建帮助器对象
    public Login_1(DBHelper databaseManager) {
        this.databaseManager = databaseManager;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_1);

        databaseManager = new DBHelper(this);
        databaseManager.getReadableDatabase();
        Intent intent = getIntent();
        int[] user_data = new int[2];
        user_data = intent.getIntArrayExtra("user_data");
        username = intent.getStringExtra("username");
        user_site = new int[5];
        user_site[0] = user_data[1];
        textNum = new int[9];
//生成随机纵坐标
        int count = 0;
        while(count < 4){
            int num = (int)(Math.random()*4 + 1);
            boolean flag = true;
            for(int i = 0; i < count; i++){
                if(num == textNum[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                textNum[count] = num;
                count++;
            }
        }
//生成随机横坐标
        count = 4;
        while(count < 9){
            int num = (int)(Math.random()*5 + 1);
            boolean flag = true;
            for(int i = 4; i < count; i++){
                if(num == textNum[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                textNum[count] = num;
                count++;
            }
        }
//随机生成图片
        imageNum = new int[20];
        count = 0;
        int user_picture = (int)(Math.random()*20);
        imageNum[user_picture] = user_data[0];
        while(count < 20){
            if(count == user_picture){
                count++;
            }
            int num = (int)(Math.random()*40 + 1);
            boolean flag = true;
            if(num == user_data[0]){
                flag = false;
            }
            for(int i = 0; i < count; i++){
                if(num == imageNum[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                imageNum[count] = num;
                count++;
            }
        }

//给文本赋值
        for(int i = 0; i < 9; i++){
            if(i == 0){
                lt = findViewById(R.id.lt_1);
                lt.setText(""+textNum[i]);
            }else if(i == 1){
                lt = findViewById(R.id.lt_2);
                lt.setText(""+textNum[i]);
            }else if(i == 2){
                lt = findViewById(R.id.lt_3);
                lt.setText(""+textNum[i]);
            }else if(i == 3){
                lt = findViewById(R.id.lt_4);
                lt.setText(""+textNum[i]);
            }else if(i == 4){
                lt = findViewById(R.id.lt_5);
                lt.setText(""+textNum[i]);
            }else if(i == 5){
                lt = findViewById(R.id.lt_6);
                lt.setText(""+textNum[i]);
            }else if(i == 6){
                lt = findViewById(R.id.lt_7);
                lt.setText(""+textNum[i]);
            }else if(i == 7){
                lt = findViewById(R.id.lt_8);
                lt.setText(""+textNum[i]);
            }else {
                lt = findViewById(R.id.lt_9);
                lt.setText(""+textNum[i]);
            }
        }

//给图片赋值
        for(int i = 0; i < 20; i++){
            if(i == 0) {
                bt = findViewById(R.id.bt_1);
                imageSet(imageNum[i], bt);

            }else if(i == 1){
                bt = findViewById(R.id.bt_2);
                imageSet(imageNum[i], bt);
            }
            else if(i == 2){
                bt = findViewById(R.id.bt_3);
                imageSet(imageNum[i], bt);
            }
            else if(i == 3){
                bt = findViewById(R.id.bt_4);
                imageSet(imageNum[i], bt);
            }
            else if(i == 4){
                bt = findViewById(R.id.bt_5);
                imageSet(imageNum[i], bt);
            }
            else if(i == 5){
                bt = findViewById(R.id.bt_6);
                imageSet(imageNum[i], bt);
            }
            else if(i == 6){
                bt = findViewById(R.id.bt_7);
                imageSet(imageNum[i], bt);
            }
            else if(i == 7){
                bt = findViewById(R.id.bt_8);
                imageSet(imageNum[i], bt);
            }
            else if(i == 8){
                bt = findViewById(R.id.bt_9);
                imageSet(imageNum[i], bt);
            }
            else if(i == 9){
                bt = findViewById(R.id.bt_10);
                imageSet(imageNum[i], bt);
            }
            else if(i == 10){
                bt = findViewById(R.id.bt_11);
                imageSet(imageNum[i], bt);
            }
            else if(i == 11){
                bt = findViewById(R.id.bt_12);
                imageSet(imageNum[i], bt);
            }
            else if(i == 12){
                bt = findViewById(R.id.bt_13);
                imageSet(imageNum[i], bt);
            }
            else if(i == 13){
                bt = findViewById(R.id.bt_14);
                imageSet(imageNum[i], bt);
            }
            else if(i == 14){
                bt = findViewById(R.id.bt_15);
                imageSet(imageNum[i], bt);
            }
            else if(i == 15){
                bt = findViewById(R.id.bt_16);
                imageSet(imageNum[i], bt);
            }
            else if(i == 16){
                bt = findViewById(R.id.bt_17);
                imageSet(imageNum[i], bt);
            }
            else if(i == 17){
                bt = findViewById(R.id.bt_18);
                imageSet(imageNum[i], bt);
            }
            else if(i == 18){
                bt = findViewById(R.id.bt_19);
                imageSet(imageNum[i], bt);
            }
            else if(i == 19){
                bt = findViewById(R.id.bt_20);
                imageSet(imageNum[i], bt);
            }
        }

        user_site[1] = user_picture / 4;
        user_site[2] = user_picture % 4;
        user_site[3] = textNum[4 + user_picture / 4];
        user_site[4] = textNum[user_picture % 4];
//user_site[0]是选定区域的号，user_site[1]是横坐标位置（0，1，2，3，4），user_site[2]是纵坐标位置（0，1，2，3）
//user_site[3]是横坐标数值（1，2，3，4，5），user_site[4]是纵坐标数值（1，2，3，4）
        button = findViewById(R.id.ln_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = null;
                intent1 = new Intent(Login_1.this, Login_2.class);
                intent1.putExtra("area", user_site);
                intent1.putExtra("username", username);
                startActivity(intent1);
            }
        });
    }
//选择对应图片
    public void imageSet(int num, ImageView image){
        switch (num){
            case 1:
                image.setImageDrawable(getDrawable(R.drawable.pp_1));
                break;
            case 2:
                image.setImageDrawable(getDrawable(R.drawable.pp_2));
                break;
            case 3:
                image.setImageDrawable(getDrawable(R.drawable.pp_3));
                break;
            case 4:
                image.setImageDrawable(getDrawable(R.drawable.pp_4));
                break;
            case 5:
                image.setImageDrawable(getDrawable(R.drawable.pp_5));
                break;
            case 6:
                image.setImageDrawable(getDrawable(R.drawable.pp_6));
                break;
            case 7:
                image.setImageDrawable(getDrawable(R.drawable.pp_7));
                break;
            case 8:
                image.setImageDrawable(getDrawable(R.drawable.pp_8));
                break;
            case 9:
                image.setImageDrawable(getDrawable(R.drawable.pp_9));
                break;
            case 10:
                image.setImageDrawable(getDrawable(R.drawable.pp_10));
                break;
            case 11:
                image.setImageDrawable(getDrawable(R.drawable.pp_11));
                break;
            case 12:
                image.setImageDrawable(getDrawable(R.drawable.pp_12));
                break;
            case 13:
                image.setImageDrawable(getDrawable(R.drawable.pp_13));
                break;
            case 14:
                image.setImageDrawable(getDrawable(R.drawable.pp_14));
                break;
            case 15:
                image.setImageDrawable(getDrawable(R.drawable.pp_15));
                break;
            case 16:
                image.setImageDrawable(getDrawable(R.drawable.pp_16));
                break;
            case 17:
                image.setImageDrawable(getDrawable(R.drawable.pp_17));
                break;
            case 18:
                image.setImageDrawable(getDrawable(R.drawable.pp_18));
                break;
            case 19:
                image.setImageDrawable(getDrawable(R.drawable.pp_19));
                break;
            case 20:
                image.setImageDrawable(getDrawable(R.drawable.pp_20));
                break;
            case 21:
                image.setImageDrawable(getDrawable(R.drawable.pp_21));
                break;
            case 22:
                image.setImageDrawable(getDrawable(R.drawable.pp_22));
                break;
            case 23:
                image.setImageDrawable(getDrawable(R.drawable.pp_23));
                break;
            case 24:
                image.setImageDrawable(getDrawable(R.drawable.pp_24));
                break;
            case 25:
                image.setImageDrawable(getDrawable(R.drawable.pp_25));
                break;
            case 26:
                image.setImageDrawable(getDrawable(R.drawable.pp_26));
                break;
            case 27:
                image.setImageDrawable(getDrawable(R.drawable.pp_27));
                break;
            case 28:
                image.setImageDrawable(getDrawable(R.drawable.pp_28));
                break;
            case 29:
                image.setImageDrawable(getDrawable(R.drawable.pp_29));
                break;
            case 30:
                image.setImageDrawable(getDrawable(R.drawable.pp_30));
                break;
            case 31:
                image.setImageDrawable(getDrawable(R.drawable.pp_31));
                break;
            case 32:
                image.setImageDrawable(getDrawable(R.drawable.pp_32));
                break;
            case 33:
                image.setImageDrawable(getDrawable(R.drawable.pp_33));
                break;
            case 34:
                image.setImageDrawable(getDrawable(R.drawable.pp_34));
                break;
            case 35:
                image.setImageDrawable(getDrawable(R.drawable.pp_35));
                break;
            case 36:
                image.setImageDrawable(getDrawable(R.drawable.pp_36));
                break;
            case 37:
                image.setImageDrawable(getDrawable(R.drawable.pp_37));
                break;
            case 38:
                image.setImageDrawable(getDrawable(R.drawable.pp_38));
                break;
            case 39:
                image.setImageDrawable(getDrawable(R.drawable.pp_39));
                break;
            case 40:
                image.setImageDrawable(getDrawable(R.drawable.pp_40));
                break;
        }
    }
}