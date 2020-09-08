package com.example.shoppingsecond.home.user;

import com.example.shoppingsecond.base.BasePresenter;
import com.example.shoppingsecond.bean.HomeBannderBean;
import com.example.shoppingsecond.common.CommonSubscriber;
import com.example.shoppingsecond.interfaces.home.IHome;
import com.example.shoppingsecond.model.HttpManager;
import com.example.shoppingsecond.utils.RxUtils;

public class HomePersenter extends BasePresenter<IHome.View>implements IHome.Persenter {
    @Override
    public void getBannerReturn() {
        addSubscribe(HttpManager.getInstance().getYunApi().getBanner()
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<HomeBannderBean>(mView){
                    @Override
                    public void onNext(HomeBannderBean homeBannderBean) {
                        mView.getBannerReturn(homeBannderBean);
                    }
                }));
    }
}
