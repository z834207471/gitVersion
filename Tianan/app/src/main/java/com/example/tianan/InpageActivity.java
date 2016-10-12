package com.example.tianan;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InpageActivity extends AppCompatActivity  {
    private ImageView iview;
    private static boolean isExit = false;
    private HorizontalScrollView hzscr;
   // private MyCountDownTimer mc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        * 去掉标题栏
        * */
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //获得窗口对象
        Window myWindow = this.getWindow();
        //设置Flag标识
        myWindow.setFlags(flag, flag);
        setContentView(R.layout.activity_in);

//        Dialog dialog = new AlertDialog.Builder(getApplicationContext(), R.style.TransparentWindowBg).setView(iview).create();
//        Window window = dialog.getWindow();
//        WindowManager.LayoutParams params = window.getAttributes();
//        params.gravity = Gravity.BOTTOM;
//        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
//        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        window.setAttributes(params);
//        window.setType(WindowManager.LayoutParams.TYPE_SYSTEM_ERROR);
//        dialog.setCancelable(false);
//        dialog.show();
//

        iview = (ImageView) findViewById(R.id.myImageView);
        hzscr = (HorizontalScrollView) findViewById(R.id.hzscr);
        hzscr.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        final TranslateAnimation animation = new TranslateAnimation(-400,-480,0,0);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        iview.setAnimation(animation);
        animation.startNow();
//        mc = new MyCountDownTimer(3000, 1000);
//        mc.start();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(InpageActivity.this,MyActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
    private Handler handle=new Handler();
   // class MyCountDownTimer extends CountDownTimer {
        /**
         *
         * 表示以毫秒为单位 倒计时的总数
         *
         * 例如 millisInFuture=1000 表示1秒
         *
         * 表示 间隔 多少微秒 调用一次 onTick 方法
         *
         * 例如: countDownInterval =1000 ; 表示每1000毫秒调用一次onTick()
         *
         */
//        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
//            super(millisInFuture,countDownInterval);
//        }
//        public void onFinish() {
//        }
//        public void onTick(long millisUntilFinished) {
//        }
//    }

        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                return false;
            }
            return super.onKeyDown(keyCode, event);
        }



}
