package com.example.hvn15.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity{
    private String TAG = "MainActivity";

    private SeekBar seekBar;
    private TextView textView;
    private EditText price_before;
    private EditText price_after;
    private EditText discount_here;
    int progress = 24;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar2);
        textView = (TextView) findViewById(R.id.textView);
        price_before = (EditText) findViewById(R.id.price_before);
        price_after = (EditText) findViewById(R.id.price_after);
        discount_here = (EditText) findViewById(R.id.dicount_here);
        price_after.setFocusable(false);
        price_after.setClickable(false);
        textView.setText("discount: " + progress + "%");
        seekBar.setMax(99);
        seekBar.setProgress(progress);

        discount_here.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    seekBar.setProgress(Integer.parseInt(discount_here.getText().toString()) - 1);
                } catch(Exception e){
                    Log.d(TAG,e.getMessage());
                }
                Log.d(TAG,discount_here.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress2, boolean fromUser) {
                progress = progress2 + 1;
                //discount_here.setText(""+progress);
                textView.setText("discount: " + progress + "%");
                if(!price_before.getText().toString().equals("")){
                    Double new_price = Double.parseDouble(price_before.getText().toString());
                    Double save_price = new_price;
                    Double discount = (((double) progress) /100);
                    new_price = (new_price*discount);
                    Double finalPrice = save_price - new_price;
                    Double bla = Math.round(finalPrice * 2) / 2.0;

                    Log.d(TAG, new_price.toString());
                   price_after.setText("" + String.format("%.2f", bla));
                } else {
                    price_after.setText("");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
