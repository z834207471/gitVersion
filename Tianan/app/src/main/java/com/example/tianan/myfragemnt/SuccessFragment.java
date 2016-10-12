package com.example.tianan.myfragemnt;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tianan.LoadActivity;
import com.example.tianan.R;

/**
 * Created by 瑞 on 2016/8/11.
 */
public class SuccessFragment extends Fragment implements View.OnClickListener {
    private Button successful;

    public SuccessFragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.success, container, false);
        successful = (Button) view.findViewById(R.id.successful);
        successful.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.successful:
                Intent intent = new Intent(getActivity(), LoadActivity.class);
                startActivity(intent);
                getActivity().finish();
                break;
            default:
                break;
        }
    }
}
