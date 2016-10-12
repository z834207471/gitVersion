package com.example.tianan.myfragemnt;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tianan.R;

import java.util.ArrayList;

/**
 * Created by 瑞 on 2016/8/10.
 */
public class StateFragment extends Fragment implements View.OnClickListener{
    private Step1Fragment s1f;
    private Step2Fragment s2f;
    private Step3Fragment s3f;
    private Step4Fragment s4f;
    private Step5Fragment s5f;
    private ImageView r1, r2, r3, r4;
    private TextView inspet, reveivhouse, acknowledgement, transact, finishi;

    public StateFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.state, container, false);
        s1f = new Step1Fragment();
        s2f = new Step2Fragment();
        s3f = new Step3Fragment();
        s4f = new Step4Fragment();
        s5f = new Step5Fragment();
        r1 = (ImageView) view.findViewById(R.id.right1);
        r2 = (ImageView) view.findViewById(R.id.right2);
        r3 = (ImageView) view.findViewById(R.id.right3);
        r4 = (ImageView) view.findViewById(R.id.right4);
        inspet = (TextView) view.findViewById(R.id.inspet);
        reveivhouse = (TextView) view.findViewById(R.id.reveivhouse);
        acknowledgement = (TextView) view.findViewById(R.id.acknowledgement);
        transact = (TextView) view.findViewById(R.id.transact);
        finishi = (TextView) view.findViewById(R.id.finishi);
        setSelect();
        inspet.setSelected(true);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.stateLayout, s1f);
        ft.commit();
        inspet.setOnClickListener(this);
        reveivhouse.setOnClickListener(this);
        acknowledgement.setOnClickListener(this);
        transact.setOnClickListener(this);
        finishi.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.inspet:
                setSelect();
                inspet.setSelected(true);
                ft.replace(R.id.stateLayout, s1f);
                break;
            case R.id.reveivhouse:
                setSelect();
                inspet.setSelected(true);
                reveivhouse.setSelected(true);
                r1.setSelected(true);
                ft.replace(R.id.stateLayout, s2f);
                break;
            case R.id.acknowledgement:
                setSelect();
                inspet.setSelected(true);
                reveivhouse.setSelected(true);
                r1.setSelected(true);
                r2.setSelected(true);
                acknowledgement.setSelected(true);
                ft.replace(R.id.stateLayout, s3f);
                break;
            case R.id.transact:
                setSelect();
                inspet.setSelected(true);
                reveivhouse.setSelected(true);
                r1.setSelected(true);
                r2.setSelected(true);
                acknowledgement.setSelected(true);
                r3.setSelected(true);
                transact.setSelected(true);
                ft.replace(R.id.stateLayout, s4f);
                break;
            case R.id.finishi:
                setSelect();
                inspet.setSelected(true);
                reveivhouse.setSelected(true);
                r1.setSelected(true);
                r2.setSelected(true);
                acknowledgement.setSelected(true);
                r3.setSelected(true);
                transact.setSelected(true);
                r4.setSelected(true);
                finishi.setSelected(true);
                ft.replace(R.id.stateLayout, s5f);
                break;
        }
        ft.commit();
    }

    public void setSelect() {
        r1.setSelected(false);
        r2.setSelected(false);
        r3.setSelected(false);
        r4.setSelected(false);
        inspet.setSelected(false);
        reveivhouse.setSelected(false);
        acknowledgement.setSelected(false);
        transact.setSelected(false);
        finishi.setSelected(false);
    }


}
