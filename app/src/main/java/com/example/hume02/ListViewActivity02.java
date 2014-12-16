package com.example.hume02;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tcp on 2014/12/15.
 */
public class ListViewActivity02 extends ListActivity{
    private String[] myListTitle = {"姓名","性别","学校","学号","居住地","国籍"};
    private String[] myListText = {"马克思","男","武汉大学","2008301200079","武汉","中国"};
    private ArrayList<Map<String,Object>> myData = new ArrayList<>();
    private ListView myListview = null;
    private int length = myListTitle.length;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        myListview = getListView();
        SimpleAdapter simpeadapter = new SimpleAdapter(this,getListdata(),android.R.layout.simple_list_item_2,
                new String[]{"title","text"},new int[]{android.R.id.text1,android.R.id.text2});
        setListAdapter(simpeadapter);

        myListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity02.this, "您选择了标题:" + myListTitle[position]+"内容:"+myListText[position], Toast.LENGTH_LONG).show();
            }
        });
        super.onCreate(savedInstanceState);
    }
    
    private ArrayList<Map<String,Object>> getListdata()//获取数据的方法
    {
        for(int i=0; i<length; ++i)
        {
            Map<String,Object> item = new HashMap<>();
            item.put("title",myListTitle[i]);
            item.put("text",myListText[i]);
            myData.add(item);
        }
        return myData;
    }

}
