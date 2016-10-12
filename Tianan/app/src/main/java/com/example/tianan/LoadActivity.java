package com.example.tianan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tianan.gaorui.Judge;

import org.w3c.dom.Text;

public class LoadActivity extends AppCompatActivity implements View.OnClickListener {
    private Button register, load;
    private EditText phonenum, password;
    private ImageButton passhow;
    private Context context;
    private boolean mbDisplayFlg = false;
    private ImageView weixin, tengxun, xinlang;
    private TextView forget;
    private static boolean isExit = false;
    private static boolean isLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = LoadActivity.this;




        bindView();
        if (isLoad == true) {
            Intent intent = new Intent(context, MyActivity.class);
            startActivity(intent);
            finish();
        } else {
            context = LoadActivity.this;
            load.setOnClickListener(this);
            register.setOnClickListener(this);
            passhow.setOnClickListener(this);
            weixin.setOnClickListener(this);
            tengxun.setOnClickListener(this);
            xinlang.setOnClickListener(this);
            forget.setOnClickListener(this);
        }
    }

    private void bindView() {
        SharedPreferences sp = getSharedPreferences("gaorui", MODE_PRIVATE);
        isLoad = sp.getBoolean("state", false);
        register = (Button) findViewById(R.id.register);
        load = (Button) findViewById(R.id.load);
        phonenum = (EditText) findViewById(R.id.phonenum);
        password = (EditText) findViewById(R.id.password);
        passhow = (ImageButton) findViewById(R.id.passhow);
        weixin = (ImageView) findViewById(R.id.weixin);
        tengxun = (ImageView) findViewById(R.id.tentxun);
        xinlang = (ImageView) findViewById(R.id.xinlang);
        forget = (TextView) findViewById(R.id.forget);
        passhow.setSelected(false);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.load:
                String mobiles = phonenum.getText().toString();
                String pas = password.getText().toString();
                if (mobiles.equals("") || pas.equals("")) {
                    Toast.makeText(context, "账号或密码为空,请输入账号或密码!", Toast.LENGTH_SHORT).show();
                }
//                else if ((Judge.isMobileNO(mobiles) == true) && (Judge.isPassword(pas))) {
                else {
                    SharedPreferences sp = getSharedPreferences("gaorui", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("state", true);
                    editor.commit();
                    Intent intent = new Intent(context, MyActivity.class);
                    startActivity(intent);
                    finish();
                }
//                else {
//                    Toast.makeText(context, "账号或密码不正确!", Toast.LENGTH_SHORT).show();
//                    phonenum.setHint("请输入您的手机号");
//                    password.setHint("请输入您的密码");
//                }
                break;
            case R.id.register:
                Intent intent = new Intent(context, RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.passhow:
                if (!mbDisplayFlg) {
                    passhow.setSelected(true);
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    passhow.setSelected(false);
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                mbDisplayFlg = !mbDisplayFlg;
                password.postInvalidate();
                break;
            case R.id.weixin:
                Toast.makeText(context, "您正在使用微信登录功能", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tentxun:
                Toast.makeText(context, "您正在使用QQ登录功能", Toast.LENGTH_SHORT).show();
                break;
            case R.id.xinlang:
                Toast.makeText(context, "您正在使用新浪微博登录功能", Toast.LENGTH_SHORT).show();
                break;
            case R.id.forget:
            default:
                break;
        }
    }

    /*
    * 重写返回键
    * */
    Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }

}
