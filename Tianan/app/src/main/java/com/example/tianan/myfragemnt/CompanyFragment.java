package com.example.tianan.myfragemnt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tianan.ChangeActivity;
import com.example.tianan.R;
import com.example.tianan.RegisterActivity;

/**
 * Created by 瑞 on 2016/8/10.
 */
public class CompanyFragment extends Fragment implements View.OnClickListener {
    private Button ccompany;

    public CompanyFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.company, container, false);
        ccompany = (Button) view.findViewById(R.id.changecompany);
        ccompany.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.changecompany:
                Intent intent = new Intent(getActivity(), ChangeActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
