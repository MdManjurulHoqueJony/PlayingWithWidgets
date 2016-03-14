package com.wordpress.jonyonandroidcraftsmanship.playingwithwidgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

    private ArrayAdapter<CharSequence> stringArrayAdapter=null;
    private Spinner spn=null;
    private MyOnItemSelectedListener myOnItemSelectedListener=null;
    private EditText et=null;
    private MyOnEditorActionListener myOnEditorActionListener=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.toast(this, MyApplication.jony);
        initialize();
    }

    private void initialize() {
        spn= (Spinner) findViewById(R.id.spn);
        et= (EditText) findViewById(R.id.et);
        stringArrayAdapter=ArrayAdapter.createFromResource(this,R.array.days,R.layout.my_dropdown_item);
        myOnItemSelectedListener=new MyOnItemSelectedListener();
        myOnEditorActionListener = new MyOnEditorActionListener();

        spn.setAdapter(stringArrayAdapter);
        spn.setOnItemSelectedListener(myOnItemSelectedListener);
        et.setOnEditorActionListener(myOnEditorActionListener);
    }

    private class MyOnItemSelectedListener implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            TextView tv= (TextView) view;
            Logger.toast(MainActivity.this,tv.getText().toString() + position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class MyOnEditorActionListener implements TextView.OnEditorActionListener{

        @Override
        public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {
            if (actionId== EditorInfo.IME_ACTION_DONE){
                Logger.toast(MainActivity.this,getString(R.string.demo)+textView.getText());
                return true;
            }
            return false;
        }
    }
}
