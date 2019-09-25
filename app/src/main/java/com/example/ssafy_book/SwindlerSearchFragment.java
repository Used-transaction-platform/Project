package com.example.ssafy_book;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SwindlerSearchFragment extends Fragment {
    View view;

    TextView textView;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_swindler_search, container, false);

        textView = view.findViewById(R.id.swindler_count);

        textView.setText(SwindlerFragment.count + "건");

        return view;
    }
}
