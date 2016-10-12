package com.example.tianan.myfragemnt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tianan.R;

/**
 * Created by 瑞 on 2016/8/10.
 */
public class Step5Fragment extends Fragment {
    public Step5Fragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.step5, container, false);
        return view;
    }
}