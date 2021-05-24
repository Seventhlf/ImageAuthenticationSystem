package com.example.application;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity{

    public Button button_d;
    public Button button_z;
    private Intent log,reg;

    private DBHelper databaseManager;   //用于创建帮助器对象
    private SQLiteDatabase db;   //用于创建数据库对象
    public void createDatabase(View view){
        databaseManager = new DBHelper(this);
        db = databaseManager.getWritableDatabase();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //databaseManager.onCreate(db);
        button_d = findViewById(R.id.log_1);
        button_z = findViewById(R.id.reg_1);
        //登录跳转
        button_d.setOnClickListener(new ButtonListener());
        //注册跳转
        button_z.setOnClickListener(new ButtonListener());
    }

    private class ButtonListener implements View.OnClickListener{
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.log_1:
                    log = new Intent(MainActivity.this, Username_1.class);
                    log.putExtra("mode",1);
                    startActivity(log);
                    break;
                case R.id.reg_1:
                    reg = new Intent(MainActivity.this, Username_1.class);
                    reg.putExtra("mode",2);
                    startActivity(reg);
                    break;
            }
        }
    }
}