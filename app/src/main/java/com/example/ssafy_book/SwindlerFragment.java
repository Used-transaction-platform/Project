package com.example.ssafy_book;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class SwindlerFragment extends Fragment {
    View view;

    ImageView search;

    FragmentTransaction fragTransaction;
    FragmentManager fragManager;

    TextView swindler;

    public static int count = 0;

    Spinner spinner;
    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_swindler, container, false);

        spinner = (Spinner) view.findViewById(R.id.spinner);
        search = view.findViewById(R.id.search_img);
        swindler = view.findViewById(R.id.report_count);

        SwindlerSearchFragment swindlerSearchFragment = new SwindlerSearchFragment();

        swindler.setText( count + "건");

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragManager = getFragmentManager();
                fragTransaction = fragManager.beginTransaction();
                fragTransaction.replace(R.id.frame,swindlerSearchFragment);
                fragTransaction.addToBackStack(null);

                fragTransaction.commit();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayList<String> items = new ArrayList<String>();
        items.add("이름");
        items.add("ID");
        items.add("전화번호");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,items);
        spinner.setAdapter(adapter);

        return view;
    }

}
