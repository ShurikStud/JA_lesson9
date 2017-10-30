package com.example.shurik.observerandroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shurik on 30.10.2017.
 */

public class Data implements IMyObserveble {

    private List<IMyObserver> listObservers = null;

    private String data;

    public Data() {
        listObservers   = new ArrayList<>();
    }

    @Override
    public void registerObserver(IMyObserver object) {

        listObservers.add(object);
    }

    @Override
    public void removeObserver(IMyObserver object) {

        listObservers.remove(object);

    }

    @Override
    public void notifyObserver() {

        for (IMyObserver observer : listObservers){

            observer.update(data);
        }
    }

    public void setData(String data){
        this.data   = data;
        notifyObserver();
    }

}
