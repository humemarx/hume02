package com.example.hume02;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by tcp on 2014/12/16.
 */
public class ListViewActivity04 extends ListActivity{
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
        myadapter = new MyListAdapter(this);
        setListAdapter(myadapter);
        myListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View v = parent.getChildAt(position);
                v.setBackgroundColor(mColors[(int)(Math.random()*11)]);
                Toast.makeText(ListViewActivity04.this, "您选择了标题:" + myListTitle[position]+"内容:"+myListText[position], Toast.LENGTH_LONG).show();
            }
        });
        super.onCreate(savedInstanceState);
    }

    class MyListAdapter extends BaseAdapter{
        private int[] colors = new int[]{0xff626569, 0xff4f5257};
        public MyListAdapter(Context context){
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

        public View getView(int position,View convertView,ViewGroup parent){
            ImageView image = null;
            TextView title = null;
            TextView text = null;

            if(convertView==null){
                convertView = LayoutInflater.from(mContext).inflate(R.layout.mylist04,null);
                image = (ImageView)convertView.findViewById(R.id.color_image);
                title = (TextView)convertView.findViewById(R.id.color_title);
                text = (TextView)convertView.findViewById(R.id.color_text);
            }
            int color_position = position % colors.length;
            convertView.setBackgroundColor(colors[color_position]);
            title.setText(myListTitle[position]);
            text.setText(myListText[position]);
            image.setImageResource(myListImage[0]);

            return convertView;
        }
        private Context mContext;
    }
}
