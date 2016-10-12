package com.example.tianan.myfragemnt;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tianan.R;
import com.example.tianan.RegisterActivity;
import com.example.tianan.gaorui.Judge;

/**
 * Created by 瑞 on 2016/8/11.
 */
public class Register1Fragment extends Fragment implements View.OnClickListener {
    private Button next;
    private Register2Fragment fr2f;
    private EditText phonenum, email, password, passwordqueren;
    private String name = "gaorui";

    public Register1Fragment() {
        super();
    }

    private String mobilenum, inputemail, inputpassword, inputpasqr;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_item1, container, false);
        next = (Button) view.findViewById(R.id.next);
        phonenum = (EditText) view.findViewById(R.id.editphonenum);
        email = (EditText) view.findViewById(R.id.editemail);
        password = (EditText) view.findViewById(R.id.editpass);
        passwordqueren = (EditText) view.findViewById(R.id.editqueren);
        fr2f = new Register2Fragment();
        next.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fTransaction = getFragmentManager().beginTransaction();
        mobilenum = phonenum.getText().toString();
        inputemail = email.getText().toString();
        inputpassword = password.getText().toString();
        inputpasqr = passwordqueren.getText().toString();
        switch (view.getId()) {
            case R.id.next:
                if (inputpassword.equals("")) {
                    Toast.makeText(getActivity(), "请填写密码!", Toast.LENGTH_SHORT).show();
                } else if (mobilenum.equals("")) {
                    Toast.makeText(getActivity(), "请填写正确的手机号!", Toast.LENGTH_SHORT).show();
                } else if (inputemail.equals("")) {
                    Toast.makeText(getActivity(), "请填写正确的邮箱!", Toast.LENGTH_SHORT).show();
                } else if (inputpasqr.equals("")) {
                    Toast.makeText(getActivity(), "请再次填写密码!", Toast.LENGTH_SHORT).show();
                } else if (!inputpassword.equals(inputpasqr)) {
                    Toast.makeText(getActivity(), "两次填写的密码不一致!", Toast.LENGTH_SHORT).show();
                } else if (inputpassword.equals(inputpasqr)) {
                    ((clicknext) getActivity()).getRe1(mobilenum, inputemail, inputpassword);
                    ((clicknext) getActivity()).setLeft();
                    fTransaction.replace(R.id.registerfragment, fr2f);
                    fTransaction.commit();
                }
                break;
        }
    }

    /*
    操作所在Activity按钮 利用回调,在该Fragment中创建接口，Acivity继承该接口，并实现方法，再在fragment中添加参数
    * 获取参数值得接口
    * */
    public interface clicknext {
        void getRe1(String num, String email, String password);

        void setLeft();
    }
}
