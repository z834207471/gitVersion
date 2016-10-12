package com.example.tianan;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 瑞 on 2016/8/11.
 */
public class MyAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> aList;

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    public MyAdapter(FragmentManager fm, ArrayList<Fragment> aList) {
        super(fm);
        this.aList = aList;
    }

    @Override
    public Fragment getItem(int position) {
        return aList.get(position);
    }

    @Override
    public int getCount() {
        return aList.size();
    }
}
