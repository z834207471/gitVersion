package com.example.tianan;

import android.app.ActivityManager;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tianan.myfragemnt.CompanyFragment;
import com.example.tianan.myfragemnt.MyFragment;
import com.example.tianan.myfragemnt.StateFragment;
import com.example.tianan.myfragemnt.Step2Fragment;
import com.example.tianan.myfragemnt.Step3Fragment;
import com.example.tianan.myfragemnt.Step4Fragment;
import com.example.tianan.myfragemnt.Step5Fragment;

import java.util.ArrayList;

public class MyActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {
    private RadioGroup myradiogroup;
    private RadioButton state, company, myself;
    private Context context;
    private ViewPager vpager;
    private StateFragment fstate;
    private CompanyFragment fcompany;
    private MyFragment fmy;
    private ArrayList<Fragment> aList;

    private static boolean isExit = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        context = MyActivity.this;
        bindView();
        state.setChecked(true);
    }

    private void bindView() {
        fmy = new MyFragment();
        fstate = new StateFragment();
        fcompany = new CompanyFragment();
        aList = new ArrayList<Fragment>();
        aList.add(fstate);
        aList.add(fcompany);
        aList.add(fmy);
        vpager = (ViewPager) findViewById(R.id.vpager);
        state = (RadioButton) findViewById(R.id.staterbtn);
        myself = (RadioButton) findViewById(R.id.myselfrbtn);
        company = (RadioButton) findViewById(R.id.companyrbtn);
        myradiogroup = (RadioGroup) findViewById(R.id.myradio);

        myradiogroup.setOnCheckedChangeListener(this);
        vpager.setAdapter(new MyAdapter(getSupportFragmentManager(), aList));
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                state.setChecked(true);
                break;
            case 1:
                company.setChecked(true);
                break;
            case 2:
                myself.setChecked(true);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.staterbtn:
                vpager.setCurrentItem(0);
                break;
            case R.id.companyrbtn:
                vpager.setCurrentItem(1);
                break;
            case R.id.myselfrbtn:
                vpager.setCurrentItem(2);
                break;
        }

    }

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
