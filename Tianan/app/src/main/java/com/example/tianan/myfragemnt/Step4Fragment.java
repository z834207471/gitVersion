package com.example.tianan.myfragemnt;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.tianan.LoadActivity;
import com.example.tianan.R;

import java.util.Calendar;

/**
 * Created by 瑞 on 2016/8/10.
 */
public class Step4Fragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private LinearLayout qiyelayout, shlayout, personlayout;
    private Button qiyesave, qiyequxiao;
    private Button persave, perxiao;
    private Button shsave, shquxiao;
    private Spinner company_natrue,belong,person_num,sh_natrue,sh_money,interest;
    private TextView txt4,  set_time;
    private String type;
    private String[] numbers = {"·············请选择·············",            //给Spinner设置下拉框里面的内容
            "政府", "国有", "集体企业", "私营", "中外合资", "外商独资"};
    private String[] numbers_belong = {"·············请选择·············",            //给Spinner设置下拉框里面的内容
            "金融", "房地产", "建筑材料", "旅游", "餐饮","教育","通信","互联网/电子商务","化工"};
    private String[] numbers_per = {"·············请选择·············",            //给Spinner设置下拉框里面的内容
            "1000人以上", "500-1000人", "100-500人", "50-100人", "10-50ren ","10人以下"};
    private String[] numbers_sh_nature = {"·············请选择·············",            //给Spinner设置下拉框里面的内容
            "服装", "便利商店", "休闲娱乐", "教育培训", "餐饮 ","医药"};
    private String[] numbers_sh_money = {"·············请选择·············",            //给Spinner设置下拉框里面的内容
            "500万以上","100-500万","50-100万","10-50万","10万以下"};
    private String[] numbers_interest = {"·············请选择·············",            //给Spinner设置下拉框里面的内容
            "体育运动", "书画", "社交", "音乐","投资理财","收藏","摄影"};
    private String[] numbers_sex = {"·············请选择·············",            //给Spinner设置下拉框里面的内容
            "男", "女"};
    private String result = "";

    public Step4Fragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.step4, container, false);

        set_time = (TextView) view.findViewById(R.id.set_time);
        qiyesave = (Button) view.findViewById(R.id.qiyesave);
        qiyequxiao = (Button) view.findViewById(R.id.qiyequxiao);
        persave = (Button) view.findViewById(R.id.persave);
        perxiao = (Button) view.findViewById(R.id.perquxiao);
        shsave = (Button) view.findViewById(R.id.shsave);
        shquxiao = (Button) view.findViewById(R.id.shquxiao);
        txt4 = (TextView) view.findViewById(R.id.txt4);
        qiyelayout = (LinearLayout) view.findViewById(R.id.qiyelayout);
        shlayout = (LinearLayout) view.findViewById(R.id.shlayout);
        personlayout = (LinearLayout) view.findViewById(R.id.personlayout);
        company_natrue = (Spinner) view.findViewById(R.id.company_natrue);
        belong = (Spinner) view.findViewById(R.id.belong);
        person_num = (Spinner) view.findViewById(R.id.person_num);
        sh_natrue = (Spinner) view.findViewById(R.id.sh_natrue);
        sh_money = (Spinner) view.findViewById(R.id.sh_money);
        interest = (Spinner) view.findViewById(R.id.interest);

        SharedPreferences sp = getActivity().getSharedPreferences("type", 0);
        type = sp.getString("type", "");
        SpannableString span = new SpannableString(txt4.getText().toString());
        span.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                if (type.equals("企业")) {
                    qiyelayout.setVisibility(View.VISIBLE);
                } else if (type.equals("商户")) {
                    shlayout.setVisibility(View.VISIBLE);
                } else if (type.equals("个体")) {
                    personlayout.setVisibility(View.VISIBLE);
                }
            }
        }, 8, 10, span.SPAN_EXCLUSIVE_EXCLUSIVE);
        txt4.setText(span);
        txt4.setMovementMethod(LinkMovementMethod.getInstance());
        company_natrue.setOnItemSelectedListener(this);
        belong.setOnItemSelectedListener(this);
        person_num.setOnItemSelectedListener(this);
        sh_natrue.setOnItemSelectedListener(this);
        sh_money.setOnItemSelectedListener(this);
        interest.setOnItemSelectedListener(this);

        SpinnerAdapter adapter = new SpinnerAdapter(getActivity(), android.R.layout.simple_spinner_item, numbers);
        company_natrue.setAdapter(adapter);
        SpinnerAdapter adapter_belong = new SpinnerAdapter(getActivity(), android.R.layout.simple_spinner_item, numbers_belong);
        belong.setAdapter(adapter_belong);
        SpinnerAdapter adapter_per = new SpinnerAdapter(getActivity(), android.R.layout.simple_spinner_item, numbers_per);
        person_num.setAdapter(adapter_per);
        SpinnerAdapter adapter_sh_natrue = new SpinnerAdapter(getActivity(), android.R.layout.simple_spinner_item, numbers_sh_nature);
        sh_natrue.setAdapter(adapter_sh_natrue);
        SpinnerAdapter adapter_sh_money = new SpinnerAdapter(getActivity(), android.R.layout.simple_spinner_item, numbers_sh_money);
        sh_money.setAdapter(adapter_sh_money);
        SpinnerAdapter adapter_interest = new SpinnerAdapter(getActivity(), android.R.layout.simple_spinner_item, numbers_interest);
        interest.setAdapter(adapter_interest);

        qiyesave.setOnClickListener(this);
        qiyequxiao.setOnClickListener(this);
        persave.setOnClickListener(this);
        set_time.setOnClickListener(this);
        perxiao.setOnClickListener(this);
        shsave.setOnClickListener(this);
        shquxiao.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.set_time:
                Calendar cale1 = Calendar.getInstance();
                new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        //这里获取到的月份需要加上1哦~
                        result = year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日";
                        set_time.setText(result);
                    }
                }
                        , cale1.get(Calendar.YEAR)
                        , cale1.get(Calendar.MONTH)
                        , cale1.get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.qiyesave:
                Toast.makeText(getActivity(), "保存成功", Toast.LENGTH_SHORT).show();
                qiyelayout.setVisibility(View.GONE);
                txt4.setText("请等待处理");
                break;
            case R.id.qiyequxiao:
                qiyelayout.setVisibility(View.GONE);
                break;
            case R.id.persave:
                Toast.makeText(getActivity(), "保存成功", Toast.LENGTH_SHORT).show();
                personlayout.setVisibility(View.GONE);
                txt4.setText("请等待处理");
                break;
            case R.id.perquxiao:
                qiyelayout.setVisibility(View.GONE);
                break;
            case R.id.shsave:
                Toast.makeText(getActivity(), "保存成功", Toast.LENGTH_SHORT).show();
                shlayout.setVisibility(View.GONE);
                txt4.setText("请等待处理");
                break;
            case R.id.shquxiao:
                shlayout.setVisibility(View.GONE);
                break;

            default:
                break;

        }

    }

    /*
    * 获取下拉框中的内容的点击事件
    * */
    /*
    添加获取Spinner中的内容的事件

    */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    /*
    * 更改Spinner下拉框的字体样式:设置字体大小,设置字体颜色
    *
    * */
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public class SpinnerAdapter extends ArrayAdapter<String> {
        Context context;
        String[] items = new String[]{};

        public SpinnerAdapter(final Context context,
                              final int textViewResourceId, final String[] objects) {
            super(context, textViewResourceId, objects);
            this.items = objects;
            this.context = context;
        }

        @Override
        public View getDropDownView(int position, View convertView,
                                    ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                convertView = inflater.inflate(
                        android.R.layout.simple_spinner_item, parent, false);
            }

            TextView tv = (TextView) convertView
                    .findViewById(android.R.id.text1);
            tv.setText(items[position]);
            tv.setGravity(Gravity.CENTER);
            tv.setTextColor(Color.BLACK);
            tv.setBackgroundResource(R.color.white);
            tv.setTextSize(18);
            return convertView;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                convertView = inflater.inflate(
                        android.R.layout.simple_spinner_item, parent, false);
            }

            // android.R.id.text1 is default text view in resource of the android.
            // android.R.layout.simple_spinner_item is default layout in resources of android.

            TextView tv = (TextView) convertView
                    .findViewById(android.R.id.text1);
            tv.setText(items[position]);
            tv.setGravity(Gravity.CENTER_VERTICAL);
            tv.setTextColor(Color.BLACK);
            tv.setTextSize(18);
            return convertView;
        }
    }


}
