package com.example.hvn15.finaleapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Fragment1 extends Fragment {

    private static final String Tag = "Fragment1";

    /*private Button btnNavSecondActivity;*/
    private Button showData;
    private ArrayList<Shop> copyList = new ArrayList<Shop>();
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        /*btnNavSecondActivity = (Button) view.findViewById(R.id.btnNavSecondActivity);*/
        listView = (ListView) view.findViewById(R.id.listview);
        showData = (Button) view.findViewById(R.id.showdata);
        copyList = ((LoggedIn)getActivity()).shopList;
        Log.d(Tag, copyList.toString());

        showData.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                CustomAdapter customAdapter = new CustomAdapter();
                listView.setAdapter(customAdapter);
            }
        });
        /*btnNavSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to Second Activity", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                startActivity(intent);
            }
        });*/
        return view;
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return copyList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.customlayout, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.image);
            TextView textView1 = (TextView) view.findViewById(R.id.title);
            TextView textView2 = (TextView) view.findViewById(R.id.description_admin);

            imageView.setImageResource(R.drawable.test);
            textView1.setText(copyList.get(i).getTitle());
            textView2.setText(copyList.get(i).getDescription());
            return view;
        }
    }
}
