package com.example.shoppingsecond.interfaces.discover;


import com.example.shoppingsecond.interfaces.IBasePresenter;
import com.example.shoppingsecond.interfaces.IBaseView;
import com.example.shoppingsecond.interfaces.home.IHome;

public interface IDiscover {

    interface View extends IBaseView {

    }

    interface Persenter extends IBasePresenter<IHome.View> {

    }
}
