package com.example.tianan.myfragemnt;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tianan.R;

/**
 * Created by 瑞 on 2016/8/10.
 */
public class Step3Fragment extends Fragment {
    private TextView tv3;
    public Step3Fragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.step3, container, false);
        tv3 = (TextView) view.findViewById(R.id.loading3);
        SpannableString span = new SpannableString(tv3.getText().toString());
        span.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"领取成功",Toast.LENGTH_SHORT).show();
            }
        }, 9, 19, span.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv3.setText(span);
        tv3.setMovementMethod(LinkMovementMethod.getInstance());
        return view;
    }
}
