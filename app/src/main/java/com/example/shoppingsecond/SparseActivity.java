package com.example.shoppingsecond;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.shoppingsecond.base.BaseActiviy;
import com.example.shoppingsecond.interfaces.IBasePresenter;

public class SparseActivity extends BaseActiviy {



    @Override
    protected int getLayout() {
        return R.layout.activity_sparse;
    }

    @Override
    protected void initView() {
        startActivity(new Intent(SparseActivity.this,MainActivity.class));
    }

    @Override
    protected IBasePresenter initPersenter() {
        return null;
    }

    @Override
    protected void initData() {

    }
}
