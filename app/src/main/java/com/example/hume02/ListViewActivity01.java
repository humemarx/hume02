package com.example.hume02;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by tcp on 2014/12/15.
 */
public class ListViewActivity01 extends ListActivity {
    private ArrayList<String> myLister = new ArrayList<>();
    private ListView myListView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        myListView = getListView();
        setListAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, getMyLister()));
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity01.this,"您选择了"+ myLister.get(position),Toast.LENGTH_LONG).show();
            }
        });
    }
    private ArrayList<String>getMyLister()
    {
        myLister.add("姓名:tcp_马克思");
        myLister.add("性别:男");
        myLister.add("学校:武汉大学");
        myLister.add("学号:2008301200079");
        myLister.add("居住地:武汉");
        myLister.add("国家:中国");
        return myLister;
    }
}
