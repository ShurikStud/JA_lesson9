package com.example.shurik.observerandroid;

/**
 * Created by shurik on 30.10.2017.
 */

public interface IMyObserveble {

    void registerObserver(IMyObserver object);
    void removeObserver(IMyObserver object);
    void notifyObserver();

}
