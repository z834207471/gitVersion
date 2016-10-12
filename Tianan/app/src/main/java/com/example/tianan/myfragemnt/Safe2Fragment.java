package com.example.tianan.myfragemnt;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.tianan.R;

/**
 * Created by 瑞 on 2016/8/14.
 */
public class Safe2Fragment extends Fragment implements View.OnClickListener {
    private Button safesave, safequxiao;

    public Safe2Fragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.safe2, container, false);
        safesave = (Button) view.findViewById(R.id.safesave);
        safequxiao = (Button) view.findViewById(R.id.safequxiao);
        safesave.setOnClickListener(this);
        safequxiao.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.safesave:
                Toast.makeText(getActivity(), "保存成功", Toast.LENGTH_SHORT).show();
                getActivity().finish();
                break;
            case R.id.safequxiao:
                getActivity().finish();
        }

    }

}
