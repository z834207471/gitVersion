package com.example.tianan.myfragemnt;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tianan.LoadActivity;
import com.example.tianan.R;
import com.example.tianan.RoundImageView;
import com.example.tianan.SafeActivity;
import com.example.tianan.AboutMe;

/**
 * Created by 瑞 on 2016/8/10.
 */
public class MyFragment extends Fragment implements View.OnClickListener {
    private TextView changepassword,aboutme;
    private Button tuichu;
    private RoundImageView img_round;

    public MyFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my, container, false);
        changepassword = (TextView) view.findViewById(R.id.changepassword);
        tuichu = (Button) view.findViewById(R.id.tuichu);
        aboutme = (TextView) view.findViewById(R.id.aboutme);
        img_round = (RoundImageView) view.findViewById(R.id.groundview);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.timg);
        img_round.setBitmap(bitmap);

//        changepassword.setSelected(false);
//        changepassword.setOnTouchListener(this);
        changepassword.setOnClickListener(this);
        tuichu.setOnClickListener(this);
        aboutme.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.changepassword:
                Intent intent1 = new Intent(getActivity(), SafeActivity.class);
                startActivity(intent1);
                break;
            case R.id.tuichu:
                new AlertDialog.Builder(getActivity())
                        .setTitle("退出")
                        .setMessage("确定退出登录？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                SharedPreferences sp =getActivity().getSharedPreferences("gaorui", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sp.edit();
                                editor.clear().commit();
                                Intent intent = new Intent(getActivity(), LoadActivity.class);
                                startActivity(intent);
                                getActivity().finish();
                            }
                        })
                        .setNegativeButton("取消", null).show();
                break;
            case R.id.aboutme:
                Intent intent2 = new Intent(getActivity(), AboutMe.class);
                startActivity(intent2);
                break;
            default:
                break;
        }

    }

}


