package com.example.shoppingsecond;

import android.widget.RelativeLayout;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.shoppingsecond.NavigationFragment.Classify.ClassifyFragment;
import com.example.shoppingsecond.NavigationFragment.HomePage.HomePageFragment;
import com.example.shoppingsecond.NavigationFragment.My.MyFragment;
import com.example.shoppingsecond.NavigationFragment.Special.SpecialFragment;
import com.example.shoppingsecond.base.BaseActiviy;
import com.example.shoppingsecond.interfaces.IBasePresenter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends BaseActiviy {


    private HomePageFragment homePage_fragment;
    private ClassifyFragment classifyFragment;
    private SpecialFragment specialFragment;
    private MyFragment myFragment;
    private FragmentManager fm;
    private RelativeLayout fragment;
    private TabLayout tab;


    @Override
    protected IBasePresenter initPersenter() {
        return null;
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void initView() {
        //获取控件qw
        fragment = (RelativeLayout) findViewById(R.id.fragment);
        tab = (TabLayout) findViewById(R.id.tab);
        fm = getSupportFragmentManager();
        //获取页面
        homePage_fragment = new HomePageFragment();
        classifyFragment = new ClassifyFragment();
        specialFragment = new SpecialFragment();
        myFragment = new MyFragment();
        initHome();
        tab.addTab(tab.newTab().setText("我的").setIcon(R.drawable.homepage_item), 0);
        tab.addTab(tab.newTab().setText("分类").setIcon(R.drawable.classify_item), 1);
        tab.addTab(tab.newTab().setText("专题").setIcon(R.drawable.special_item), 2);
        tab.addTab(tab.newTab().setText("我的").setIcon(R.drawable.my_item), 3);
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                initFragment(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


    private void initFragment(int position) {
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (!homePage_fragment.isAdded()) {
                    fragmentTransaction.add(R.id.fragment, homePage_fragment).hide(classifyFragment).hide(specialFragment).hide(myFragment);
                }
                fragmentTransaction.show(homePage_fragment).hide(classifyFragment).hide(specialFragment).hide(myFragment);
                fragmentTransaction.commit();
                break;
            case 1:
                if (!classifyFragment.isAdded()) {
                    fragmentTransaction.add(R.id.fragment, classifyFragment).hide(homePage_fragment).hide(specialFragment).hide(myFragment);
                }
                fragmentTransaction.show(classifyFragment).hide(homePage_fragment).hide(specialFragment).hide(myFragment);
                fragmentTransaction.commit();
                break;
            case 2:
                if (!specialFragment.isAdded()) {
                    fragmentTransaction.add(R.id.fragment, specialFragment).hide(homePage_fragment).hide(classifyFragment).hide(myFragment);
                }
                fragmentTransaction.show(specialFragment).hide(classifyFragment).hide(homePage_fragment).hide(myFragment);
                fragmentTransaction.commit();
                break;
            case 3:
                if (!myFragment.isAdded()) {
                    fragmentTransaction.add(R.id.fragment, myFragment).hide(homePage_fragment).hide(classifyFragment).hide(specialFragment);
                }
                fragmentTransaction.show(myFragment).hide(classifyFragment).hide(specialFragment).hide(homePage_fragment);
                fragmentTransaction.commit();
                break;
        }
    }

    private void initHome() {
        fm.beginTransaction()
                .add(R.id.fragment, homePage_fragment)
                .show(homePage_fragment)
                .commit();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;

    }
}
