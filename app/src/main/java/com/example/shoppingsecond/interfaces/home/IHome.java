package com.example.shoppingsecond.interfaces.home;


import com.example.shoppingsecond.bean.HomeBannderBean;
import com.example.shoppingsecond.interfaces.IBasePresenter;
import com.example.shoppingsecond.interfaces.IBaseView;

public interface IHome {
//轮播图
    interface View extends IBaseView {
        void getBannerReturn(HomeBannderBean result);
    }

    interface Persenter extends IBasePresenter<View> {
        void getBannerReturn();
    }




}
