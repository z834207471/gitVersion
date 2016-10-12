package com.example.tianan;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.tianan.myfragemnt.Register1Fragment;
import com.example.tianan.myfragemnt.Register2Fragment;

public class RegisterActivity extends AppCompatActivity implements Register1Fragment.clicknext,
        Register2Fragment.clickfinishi, View.OnClickListener {
    private Register1Fragment r1f;
    private Button loading;
    private ImageButton left;
    private String phonenum, email, password, companyname, companytype, buildare, comadress, starttime, endtime, companynature, companycus;
    private FragmentManager fm;
    private static boolean isExit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        r1f = new Register1Fragment();
        fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.registerfragment, r1f);
        loading = (Button) findViewById(R.id.refulsload);
        left = (ImageButton) findViewById(R.id.left);
        left.setOnClickListener(this);
        loading.setOnClickListener(this);
        ft.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.refulsload:
                Intent intent = new Intent(RegisterActivity.this, LoadActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.left:
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.registerfragment, r1f);
                ft.commit();
                left.setVisibility(View.INVISIBLE);
                left.setClickable(false);
            default:
                break;
        }
    }

    @Override
    public void setLeft() {
        left.setVisibility(View.VISIBLE);
        left.setClickable(true);
    }

    @Override
    public void setLeft2() {
        left.setVisibility(View.INVISIBLE);
        left.setClickable(false);
    }

    @Override
    public void getRe2(String name, String type, String are, String adress, String starttime, String endtime, String nature, String cus) {
        this.companyname = name;
        this.companytype = type;
        this.buildare = are;
        this.comadress = adress;
        this.starttime = starttime;
        this.endtime = endtime;
        this.companynature = nature;
        this.companycus = cus;
    }

    @Override
    public void setLoad2() {
        loading.setVisibility(View.INVISIBLE);
        loading.setClickable(false);
    }

    @Override
    public void getRe1(String num, String email, String password) {
        this.phonenum = num;
        this.email = email;
        this.password = password;
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
