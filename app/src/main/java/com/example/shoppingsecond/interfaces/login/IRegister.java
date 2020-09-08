package com.example.shoppingsecond.interfaces.login;


import com.example.shoppingsecond.interfaces.IBasePresenter;
import com.example.shoppingsecond.interfaces.IBaseView;

/**
 * 契约类
 * 解决类接口过多的问题
 *
 */
public interface IRegister {

   /* interface RegisterOne{
        void register(String username,String pw);
    }

    interface RegisterBind{
        void bindPhone(String phone);
    }*/

    interface View extends IBaseView {
        void registerReturn();
    }

    interface Persenter extends IBasePresenter<View> {
        void register(String username, String pw);
    }


}
