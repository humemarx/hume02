package com.example.hume02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    private Button listview_btn01,listview_btn02,listview_btn03,listview_btn04,listview_btn05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview_btn01 = (Button)findViewById(R.id.listview_btn01);
        listview_btn02 = (Button)findViewById(R.id.listview_btn02);
        listview_btn03 = (Button)findViewById(R.id.listview_btn03);
        listview_btn04 = (Button)findViewById(R.id.listview_btn04);
        listview_btn05 = (Button)findViewById(R.id.listview_btn05);
        listview_btn01.setOnClickListener(onclicklistener);
        listview_btn02.setOnClickListener(onclicklistener);
        listview_btn03.setOnClickListener(onclicklistener);
        listview_btn04.setOnClickListener(onclicklistener);
        listview_btn05.setOnClickListener(onclicklistener);
    }
    public View.OnClickListener onclicklistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();//实现ACTIVITY的跳转
            switch (v.getId()){
                case R.id.listview_btn01:
                    intent.setClass(MainActivity.this, ListViewActivity01.class);
                    break;
                case R.id.listview_btn02:
                    intent.setClass(MainActivity.this, ListViewActivity02.class);
                    break;
                case R.id.listview_btn03:
                    intent.setClass(MainActivity.this, ListViewActivity03.class);
                    break;
                case R.id.listview_btn04:
                    intent.setClass(MainActivity.this, ListViewActivity04.class);
                    break;
                case R.id.listview_btn05:
                    intent.setClass(MainActivity.this, ListViewActivity05.class);
                    break;
                default:
                    break;
            }
            MainActivity.this.startActivity(intent);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
