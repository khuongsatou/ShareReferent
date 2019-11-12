package com.example.sharereferent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String COUNT_KEY ="count" ;
    private static final String COLOR_KEY ="color" ;
    private SharedPreferences spSave;
    int count =0;
    int color = 0;
    private TextView tvCount;


    private String sharedPreFile = "com.example.sharereferent";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("AAAAA","CREATE");
        radiation();
        saveRefer();
        restore();
    }

    private void restore() {
        // Restore preferences
        if (spSave != null){
            this.count = spSave.getInt(COUNT_KEY, 0);
            tvCount.setText(String.format("%s", this.count));
            this.color = spSave.getInt(COLOR_KEY, this.color);
            tvCount.setBackgroundColor(this.color);
        }

    }




    private void saveRefer() {
        spSave = getSharedPreferences(sharedPreFile,MODE_PRIVATE);


    }


    @Override
    protected void onPause() {
        SharedPreferences.Editor spEditor = spSave.edit();
        spEditor.putInt(COUNT_KEY, Integer.valueOf(this.count));
        spEditor.putInt(COLOR_KEY, Integer.valueOf(this.color));
        spEditor.apply();
        Log.d("AAAAA","PAUSE");
        super.onPause();
    }

    private void radiation() {
        tvCount = findViewById(R.id.tvCount);
    }

    public void Count(View view) {
        this.count ++;
        tvCount.setText(this.count+"");
    }

    public void Black(View view) {
        this.color = ContextCompat.getColor(getApplicationContext(),R.color.default_background);
        tvCount.setBackgroundColor(color);
    }

    public void Red(View view) {
        this.color = ContextCompat.getColor(getApplicationContext(),R.color.red_background);
        tvCount.setBackgroundColor(color);
    }

    public void Blue(View view) {
        this.color = ContextCompat.getColor(getApplicationContext(),R.color.blue_background);
        tvCount.setBackgroundColor(color);
    }

    public void Green(View view) {
        this.color = ContextCompat.getColor(getApplicationContext(),R.color.green_background);
        tvCount.setBackgroundColor(color);
    }

    public void Reset(View view) {
        this.count =0;
        tvCount.setText(this.count+"");
    }
}
