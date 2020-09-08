package com.example.shoppingsecond.interfaces.own;



import com.example.shoppingsecond.interfaces.IBasePresenter;
import com.example.shoppingsecond.interfaces.IBaseView;

import java.util.Map;


public interface IOwn {
    interface View extends IBaseView {
    //    void updateUserInforReturn(UpdateBean result);
    }

    interface Persenter extends IBasePresenter<View> {
    //    void updateUserInforReturn(Map<String, String> map);
    }

}
