package com.example.tianan;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ChangeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button save, quxiao;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);
        context = ChangeActivity.this;
        bindView();
        save.setOnClickListener(this);
        quxiao.setOnClickListener(this);
    }

    private void bindView() {
        save = (Button) findViewById(R.id.companysave);
        quxiao = (Button) findViewById(R.id.companyquxiao);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.companysave:
                Toast.makeText(context, "保存成功", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.companyquxiao:
                finish();
                break;
        }
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
                            ChangeActivity.this.finish();
                        }
                    })
                    .setNegativeButton("取消", null).show();
            return true;
        } else
            return super.onKeyDown(keyCode, event);
    }

}



