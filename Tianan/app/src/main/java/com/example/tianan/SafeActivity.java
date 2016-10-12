package com.example.tianan;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tianan.myfragemnt.Safe1Fragment;
import com.example.tianan.myfragemnt.Safe2Fragment;

public class SafeActivity extends AppCompatActivity implements Safe1Fragment.setSafeLeft, View.OnClickListener {
    private Context context;
    private FragmentManager fm;
    private Safe1Fragment s1f;
    private ImageButton safeleft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safe);
        context = SafeActivity.this;
        fm = getFragmentManager();
        s1f = new Safe1Fragment();
        safeleft = (ImageButton) findViewById(R.id.safeleft);
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.safechange, s1f);
        ft.commit();
        safeleft.setOnClickListener(this);

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            new AlertDialog.Builder(this)
                    .setTitle("退出")
                    .setMessage("您还没有保存信息，是否退出?")
                    .setPositiveButton("退出", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            SafeActivity.this.finish();
                        }
                    })
                    .setNegativeButton("取消", null).show();
            return true;
        } else
            return super.onKeyDown(keyCode, event);
    }

    @Override
    public void setSafeLeft() {
        safeleft.setVisibility(View.VISIBLE);
        safeleft.setClickable(true);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.safeleft:
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.safechange, s1f);
                ft.commit();
                safeleft.setVisibility(View.INVISIBLE);
                safeleft.setClickable(false);
                break;
            default:
                break;
        }
    }
}