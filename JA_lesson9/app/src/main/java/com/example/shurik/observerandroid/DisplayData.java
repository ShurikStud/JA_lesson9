package com.example.shurik.observerandroid;

import android.util.Log;

/**
 * Created by shurik on 30.10.2017.
 */

public class DisplayData implements IMyObserver {

    private static final String TAG = DisplayData.class.getSimpleName();

    private String dataString;
    private Data data;

    public DisplayData(Data data) {
        this.data = data;
        data.registerObserver(this);
    }

    @Override
    public void update(String dataString) {

        this.dataString = dataString;
        Log.v(TAG, "update ==> " + this.dataString);

    }

    public void removeObserverFromData(){

        data.removeObserver(this);
        Log.v(TAG, "remove ==> ");

    }

}
