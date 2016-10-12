package com.example.tianan.myfragemnt;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tianan.LoadActivity;
import com.example.tianan.R;

import java.util.Calendar;

/**
 * Created by 瑞 on 2016/8/11.
 */
public class Register2Fragment extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {
    private Button registerfinish;                                  //创建"完成按钮"对象
    private SuccessFragment sf;                                          //创建"SuccessFragment"对象
    private RadioButton qiye,shanghu,geti;
    private String name, type, are, adress, starttime, endtime, nature, cus;
    private RadioGroup companytype;
    private String[] numbers = {"·············请选择·············",            //给Spinner设置下拉框里面的内容
            "现场客户-业主", "现场客户-租主", "隐形客户-业主", "隐形客户-租主"};                          //
    private String[] cusnumbers = {"·············请选择·············",        //
            "业主", "租主"};
    private EditText companyname, companyare, companyadress;
    private TextView tvstarttime, tvendtime;
    private Spinner companynature, companycus;
    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;
    private String result = "";

    public Register2Fragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_item2, container, false);
        sf = new SuccessFragment();
        registerfinish = (Button) view.findViewById(R.id.registerfinish);
        companyname = (EditText) view.findViewById(R.id.companyname);
        companytype = (RadioGroup) view.findViewById(R.id.companytype);
        companyare = (EditText) view.findViewById(R.id.companyare);
        companyadress = (EditText) view.findViewById(R.id.companyadress);
        tvstarttime = (TextView) view.findViewById(R.id.starttime);
        tvendtime = (TextView) view.findViewById(R.id.endtime);
        qiye = (RadioButton) view.findViewById(R.id.qiye);
        shanghu = (RadioButton) view.findViewById(R.id.shangye);
        geti = (RadioButton) view.findViewById(R.id.geti);
        companynature = (Spinner) view.findViewById(R.id.companynature);
        //    companynature = (TextView) view.findViewById(R.id.companynature);
        companycus = (Spinner) view.findViewById(R.id.companycus);
        //    companynature.setOnClickListener(this);
        registerfinish.setOnClickListener(this);
        companytype.setOnCheckedChangeListener(this);
        tvstarttime.setOnClickListener(this);
        tvendtime.setOnClickListener(this);
        companynature.setOnItemSelectedListener(this);
        companycus.setOnItemSelectedListener(this);
        SpinnerAdapter adapter = new SpinnerAdapter(getActivity(),
                android.R.layout.simple_spinner_item, numbers);
        SpinnerAdapter adapter1 = new SpinnerAdapter(getActivity(),
                android.R.layout.simple_spinner_item, cusnumbers);
        companynature.setAdapter(adapter);
        companycus.setAdapter(adapter1);
        return view;
    }

    /*
    * 添加点击事件:registerfinish,starttime,endtime
    * */
    @Override
    public void onClick(View view) {
        FragmentTransaction fTransaction = getFragmentManager().beginTransaction();
        name = companyname.getText().toString();
        are = companyare.getText().toString();
        adress = companyadress.getText().toString();
        starttime = tvstarttime.getText().toString();
        endtime = tvendtime.getText().toString();
        result = "";
        switch (view.getId()) {
            case R.id.registerfinish:
                if (name.equals("")) {
                    Toast.makeText(getActivity(), "请填写公司名称!", Toast.LENGTH_SHORT).show();
                } else if (type == null) {
                    Toast.makeText(getActivity(), "请选择公司类型!", Toast.LENGTH_SHORT).show();
                } else if (are.equals("")) {
                    Toast.makeText(getActivity(), "请填写建筑面积!", Toast.LENGTH_SHORT).show();
                } else if (adress.equals("")) {
                    Toast.makeText(getActivity(), "请填写公司地址!", Toast.LENGTH_SHORT).show();
                } else if (starttime == "") {
                    Toast.makeText(getActivity(), "请选择开始租赁时间!", Toast.LENGTH_SHORT).show();
                } else if (endtime == "") {
                    Toast.makeText(getActivity(), "请选择结束租赁时间!", Toast.LENGTH_SHORT).show();
                } else if (nature.equals(numbers[0])) {
                    Toast.makeText(getActivity(), "请选择使用性质!", Toast.LENGTH_SHORT).show();
                } else if (cus.equals(cusnumbers[0])) {
                    Toast.makeText(getActivity(), "请选择历史顾客!", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences sp = getActivity().getSharedPreferences("type", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("type",type);
                    editor.commit();
                    ((clickfinishi) getActivity()).getRe2(name, type, are, adress, starttime, endtime, nature, cus);
                    ((clickfinishi) getActivity()).setLeft2();
                    ((clickfinishi) getActivity()).setLoad2();
                    fTransaction.replace(R.id.registerfragment, sf);
                    fTransaction.commit();
                }
                break;
//            case R.id.companynature:
//                final String[] nature = new String[]{"现场客户-业主",
//                        "现场客户-租主",
//                        "隐形客户-业主",
//                        "隐形客户-租主"};
//                alert = null;
//                builder = new AlertDialog.Builder(getActivity());
//                alert = builder.setTitle("使用性质")
//                        .setItems(nature, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                companynature.setText(nature[which]);
//                                companynature.setTextColor(ContextCompat.getColor(getActivity(),R.color.black));
//                            }
//                        }).create();
//                alert.show();
//                break;

            /*创建选择事件事件(API自带)*/
            case R.id.starttime:
                Calendar cale1 = Calendar.getInstance();
                new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        //这里获取到的月份需要加上1哦~
                        result = year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日";
                        tvstarttime.setText(result);
                    }
                }
                        , cale1.get(Calendar.YEAR)
                        , cale1.get(Calendar.MONTH)
                        , cale1.get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.endtime:
                Calendar cale11 = Calendar.getInstance();
                new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        //这里获取到的月份需要加上1哦~
                        result += year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日";
                        tvendtime.setText(result);
                    }
                }
                        , cale11.get(Calendar.YEAR)
                        , cale11.get(Calendar.MONTH)
                        , cale11.get(Calendar.DAY_OF_MONTH)).show();
                break;
            default:
                break;
        }
    }

    /*添加RadioGroup中按钮点击事件*/
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.qiye:
                type = qiye.getText().toString();
                break;
            case R.id.shangye:
                type = shanghu.getText().toString();
                break;
            case R.id.geti:
                type = geti.getText().toString();
                break;
            default:
                break;
        }
    }

    /*
    添加获取Spinner中的内容的事件

    */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        nature = companynature.getSelectedItem().toString();
        cus = companycus.getSelectedItem().toString();

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

    /*
        操作所在Activity按钮 利用回调,在该Fragment中创建接口，Acivity继承该接口，并实现方法，再在fragment中添加参数
        * 获取参数值得接口
        * */
    public interface clickfinishi {
        void getRe2(String name, String type, String are, String adress, String starttime, String endtime, String nature, String cus);

        void setLoad2();

        void setLeft2();
    }
}
