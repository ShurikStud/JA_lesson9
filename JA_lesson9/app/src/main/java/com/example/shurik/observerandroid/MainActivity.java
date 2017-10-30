package com.example.shurik.observerandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG, "===========1============");

        final Data data   = new Data();
        final DisplayData displayData = new DisplayData(data);

        Log.v(TAG, "===========2============");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //displayData.update("new string");
                        data.setData("new string");
                        Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_LONG).show();
                        displayData.removeObserverFromData();
                    }
                });
            }
        });

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        thread.start();

        Log.v(TAG, "===========3============");

    }
}
