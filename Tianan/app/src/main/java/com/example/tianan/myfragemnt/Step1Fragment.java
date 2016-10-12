package com.example.tianan.myfragemnt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tianan.R;
import com.example.tianan.RegisterActivity;

/**
 * Created by 瑞 on 2016/8/11.
 */
public class Step1Fragment extends Fragment {
    public Step1Fragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.step1, container, false);
        return view;
    }


}
