package com.example.hume02;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by tcp on 2014/12/16.
 */
public class ListViewActivity05 extends ListActivity{
    private String[] myListTitle = {"姓名","性别","学校","学号","居住地","国籍"};
    private String[] myListText = {"马克思","男","武汉大学","2008301200079","武汉","中国"};
    private int[] myListImage = {R.drawable.ic_launcher};
    private int[] mColors = {Color.WHITE,Color.DKGRAY,Color.CYAN,Color.BLUE,
            Color.YELLOW,Color.MAGENTA,Color.RED,Color.GRAY,
            Color.CYAN,Color.LTGRAY,Color.DKGRAY,Color.RED};

    private ListView myListview = null;
    private MyListAdapter myadapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        myListview = getListView();
        myadapter = new MyListAdapter(this,R.layout.mylist05);
        setListAdapter(myadapter);
        super.onCreate(savedInstanceState);
    }

    class MyListAdapter extends ArrayAdapter<Object>{
        int myTextViewResourceID = 0;
        private Context mContext;
        private int[] colors = new int[]{0xff626569, 0xff4f5257};
        public MyListAdapter(Context context,int textViewResourceID){
            super(context,textViewResourceID);
            myTextViewResourceID = textViewResourceID;
            mContext = context;
        }
        public int getCount(){
            return myListTitle.length;
        }
        public Object getItem(int position){
            return position;
        }
        public long getItemId(int position){
            return position;
        }

        public View getView(final int position,View convertView,ViewGroup parent){
            ImageView image = null;
            TextView title = null;
            TextView text = null;
            Button button;

            if(convertView==null){
                convertView = LayoutInflater.from(mContext).inflate(myTextViewResourceID,null);
                image = (ImageView)convertView.findViewById(R.id.array_image);
                title = (TextView)convertView.findViewById(R.id.array_title);
                text = (TextView)convertView.findViewById(R.id.array_text);
                button = (Button)convertView.findViewById(R.id.array_btn);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setBackgroundColor(mColors[(int)(Math.random()*11)]);
                        Toast.makeText(ListViewActivity05.this,"你点击的是:第"+position+"按钮",Toast.LENGTH_LONG).show();
                    }
                });
            }
            int color_position = position % colors.length;
            convertView.setBackgroundColor(colors[color_position]);
            title.setText(myListTitle[position]);
            text.setText(myListText[position]);
            image.setImageResource(myListImage[0]);

            return convertView;
        }
    }
}
