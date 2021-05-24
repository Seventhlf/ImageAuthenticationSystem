package com.example.application;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Username_1 extends BaseActivity {

    public Username_1(){}
    public Button next;
    public EditText text;

    private DBHelper databaseManager;   //用于创建帮助器对象

    public Username_1(DBHelper databaseManager) {
        this.databaseManager = databaseManager;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username_1);

        databaseManager = new DBHelper(this);
        SQLiteDatabase db = databaseManager.getReadableDatabase();
        text = findViewById(R.id.user);
        next = findViewById(R.id.next);
        Intent choose = getIntent();
        int mode = choose.getIntExtra("mode", 0);
//注册阶段
        if (mode == 2) {
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name;
                    name = text.getText().toString().trim();
                    if (!TextUtils.isEmpty(name)) {
                        if (databaseManager.checkByName(name) == 0){
                            databaseManager.getWritableDatabase();
                            db.beginTransaction();
                            try {
                                databaseManager.add(name, 0, 0);
                                db.setTransactionSuccessful();//设置执行成功标志
                            } finally {
                                db.endTransaction();//判断是否成功，是就commit，否则回滚所有操作
                            }
                            Toast toastCenter = Toast.makeText(getApplicationContext(), "该用户名可用", Toast.LENGTH_SHORT);
                            toastCenter.setGravity(Gravity.CENTER, 0, 0);
                            toastCenter.show();

                            Intent intent = null;
                            intent = new Intent(Username_1.this, Register_1.class);
                            intent.putExtra("Name", name);
                            startActivity(intent);
                        } else {
                            Toast toastCenter = Toast.makeText(getApplicationContext(), "该用户名已被注册，请重新输入", Toast.LENGTH_SHORT);
                            toastCenter.setGravity(Gravity.CENTER, 0, 0);
                            toastCenter.show();
                        }
                    }
                }
            });
        }else if(mode == 1){    //登录阶段
            next.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name;
                    name = text.getText().toString().trim();
                    if(!TextUtils.isEmpty(name)){
                        if(databaseManager.checkByName(name) == 0){
                            Toast toastCenter = Toast.makeText(getApplicationContext(), "该用户不存在", Toast.LENGTH_SHORT);
                            toastCenter.setGravity(Gravity.CENTER, 0, 0);
                            toastCenter.show();
                        }else{
                            databaseManager.getReadableDatabase();
                            int[] user_data = new int[2];
                            user_data[0] = databaseManager.pictureByName(name);
                            user_data[1] = databaseManager.areaByName(name);
                            Toast toastCenter = Toast.makeText(getApplicationContext(), "请记忆密码坐标", Toast.LENGTH_SHORT);
                            toastCenter.setGravity(Gravity.CENTER, 0, 0);
                            toastCenter.show();
                            Intent intent = null;
                            intent = new Intent(Username_1.this, Login_1.class);
                            intent.putExtra("user_data", user_data);
                            intent.putExtra("username", name);
                            startActivity(intent);
                        }
                    }
                }
            }));
        }
    }
}