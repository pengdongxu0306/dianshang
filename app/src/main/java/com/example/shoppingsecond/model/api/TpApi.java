package com.example.shoppingsecond.model.api;


import com.example.shoppingsecond.bean.HomeBannderBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface TpApi {
    //轮播图
    //http://169.254.96.147:8085/home/content
    @GET("home/content")
    Flowable<HomeBannderBean> getBanner();



}
