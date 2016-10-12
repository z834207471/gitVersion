package com.example.tianan.myfragemnt;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tianan.R;

/**
 * Created by 瑞 on 2016/8/14.
 */
public class Safe1Fragment extends Fragment implements View.OnClickListener {
    private Safe2Fragment s2f;
    private FragmentManager fm;
    private Button safenext;

    public Safe1Fragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.safe1, container, false);
        s2f = new Safe2Fragment();
        fm = getFragmentManager();
        safenext = (Button) view.findViewById(R.id.safenext);
        safenext.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.safenext:

                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.safechange, s2f);
                ft.commit();
                ((setSafeLeft) getActivity()).setSafeLeft();
                break;

        }
    }

    public interface setSafeLeft {
        void setSafeLeft();
    }
}
