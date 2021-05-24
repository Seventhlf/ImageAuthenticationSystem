package com.example.application;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login_2 extends BaseActivity {
    public Login_2() {
    }

    private TextView lt;
    private Button button_1, button_2, button_3;
    private int[] textNum;
    private int[] user_site;
    private int tryNum;
    private String username;

    private DBHelper databaseManager;   //用于创建帮助器对象

    public Login_2(DBHelper databaseManager) {
        this.databaseManager = databaseManager;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_2);

        databaseManager = new DBHelper(this);
        databaseManager.getReadableDatabase();
        Intent intent = getIntent();
        user_site = new int[5];
        user_site = intent.getIntArrayExtra("area");
        username = intent.getStringExtra("username");
        textNum = new int[9];
        tryNum = 3;

        //生成随机纵坐标
        int count = 0;
        while (count < 4) {
            int num = (int) (Math.random() * 4 + 1);
            boolean flag = true;
            for (int i = 0; i < count; i++) {
                if (num == textNum[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                textNum[count] = num;
                count++;
            }
        }
//生成随机横坐标
        count = 4;
        while (count < 9) {
            int num = (int) (Math.random() * 5 + 1);
            boolean flag = true;
            for (int i = 4; i < count; i++) {
                if (num == textNum[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                textNum[count] = num;
                count++;
            }
        }
//给文本赋值
        for (int i = 0; i < 9; i++) {
            if (i == 0) {
                lt = findViewById(R.id.ltt_1);
                lt.setText("" + textNum[i]);
            } else if (i == 1) {
                lt = findViewById(R.id.ltt_2);
                lt.setText("" + textNum[i]);
            } else if (i == 2) {
                lt = findViewById(R.id.ltt_3);
                lt.setText("" + textNum[i]);
            } else if (i == 3) {
                lt = findViewById(R.id.ltt_4);
                lt.setText("" + textNum[i]);
            } else if (i == 4) {
                lt = findViewById(R.id.ltt_5);
                lt.setText("" + textNum[i]);
            } else if (i == 5) {
                lt = findViewById(R.id.ltt_6);
                lt.setText("" + textNum[i]);
            } else if (i == 6) {
                lt = findViewById(R.id.ltt_7);
                lt.setText("" + textNum[i]);
            } else if (i == 7) {
                lt = findViewById(R.id.ltt_8);
                lt.setText("" + textNum[i]);
            } else {
                lt = findViewById(R.id.ltt_9);
                lt.setText("" + textNum[i]);
            }
        }

        button_2 = findViewById(R.id.lb_1);
        button_2.setOnClickListener(new ButtonListener());
        button_3 = findViewById(R.id.lb_2);
        button_3.setOnClickListener(new ButtonListener());
        button_1 = findViewById(R.id.ln_2);
        button_1.setOnClickListener(new ButtonListener());
    }

    private class ButtonListener implements View.OnClickListener {
        @SuppressLint("SetTextI18n")
        public void onClick(View v) {
            int t;
            switch (v.getId()) {
                case R.id.lb_1:
                    t = textNum[0];
                    textNum[0] = textNum[3];
                    textNum[3] = textNum[2];
                    textNum[2] = textNum[1];
                    textNum[1] = t;
                    for (int i = 0; i < 4; i++) {
                        if (i == 0) {
                            lt = findViewById(R.id.ltt_1);
                            lt.setText("" + textNum[i]);
                        } else if (i == 1) {
                            lt = findViewById(R.id.ltt_2);
                            lt.setText("" + textNum[i]);
                        } else if (i == 2) {
                            lt = findViewById(R.id.ltt_3);
                            lt.setText("" + textNum[i]);
                        } else if (i == 3) {
                            lt = findViewById(R.id.ltt_4);
                            lt.setText("" + textNum[i]);
                        }
                    }
                    break;
                case R.id.lb_2:
                    t = textNum[4];
                    textNum[4] = textNum[5];
                    textNum[5] = textNum[6];
                    textNum[6] = textNum[7];
                    textNum[7] = textNum[8];
                    textNum[8] = t;
                    for (int i = 4; i < 9; i++) {
                        if (i == 4) {
                            lt = findViewById(R.id.ltt_5);
                            lt.setText("" + textNum[i]);
                        } else if (i == 5) {
                            lt = findViewById(R.id.ltt_6);
                            lt.setText("" + textNum[i]);
                        } else if (i == 6) {
                            lt = findViewById(R.id.ltt_7);
                            lt.setText("" + textNum[i]);
                        } else if (i == 7) {
                            lt = findViewById(R.id.ltt_8);
                            lt.setText("" + textNum[i]);
                        } else if (i == 8) {
                            lt = findViewById(R.id.ltt_9);
                            lt.setText("" + textNum[i]);
                        }
                    }
                    break;
                case R.id.ln_2:
                    int ho, ve;
                    ho = (user_site[0]-1) / 4 + 4;
                    ve = (user_site[0]-1) % 4;
                    if (textNum[ho] == user_site[3] && textNum[ve] == user_site[4]) {
                        Toast toastCenter = Toast.makeText(getApplicationContext(), "欢迎登录", Toast.LENGTH_SHORT);
                        toastCenter.setGravity(Gravity.CENTER, 0, 0);
                        toastCenter.show();
                        Intent intent1 = null;
                        intent1 = new Intent(Login_2.this, Show.class);
                        intent1.putExtra("Name", username);
                        startActivity(intent1);
                    } else {
                        tryNum--;
                        if (tryNum != 0) {
                            Toast toastCenter = Toast.makeText(getApplicationContext(), "密码错误，您还剩：" + tryNum + "次机会", Toast.LENGTH_SHORT);
                            toastCenter.setGravity(Gravity.CENTER, 0, 0);
                            toastCenter.show();
                        } else {
                            Toast toastCenter = Toast.makeText(getApplicationContext(), "密码错误，该账户被注销，请联系管理员", Toast.LENGTH_SHORT);
                            toastCenter.setGravity(Gravity.CENTER, 0, 0);
                            toastCenter.show();
                            databaseManager.getWritableDatabase();
                            databaseManager.delete(username);
                            removeALLActivity();
                        }
                    }
                    break;
            }
        }
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
