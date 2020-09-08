package com.example.shoppingsecond.NavigationFragment.HomePage;

import android.content.Context;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.example.shoppingsecond.NavigationFragment.HomePage.view.AutoTextView;
import com.example.shoppingsecond.R;
import com.example.shoppingsecond.base.BaseFragment;
import com.example.shoppingsecond.bean.HomeBannderBean;
import com.example.shoppingsecond.home.user.HomePersenter;
import com.example.shoppingsecond.interfaces.home.IHome;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomePageFragment extends BaseFragment<IHome.Persenter> implements IHome.View {
    @BindView(R.id.layout)
    LinearLayout layout;
    @BindView(R.id.xiaoxi)
    ImageView xiaoxi;
    @BindView(R.id.bnt_xq)
    Button bntXq;



    @BindView(R.id.gengduo)
    ImageView gengduo;
    @BindView(R.id.card1)
    CardView card1;
    @BindView(R.id.card2)
    CardView card2;
    @BindView(R.id.advertising)
    AutoTextView advertising;

    private Handler handler = new Handler();

    private int count = 0;
    private List<String> arrList = new ArrayList<String>();


    @BindView(R.id.banner)
    Banner banner;
    private List<HomeBannderBean.DataBean.AdvertiseListBean> advertiseList;
    private Runnable runnable;


    public HomePageFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_home_page_;

    }

    @Override
    protected void initView() {
    }

    private void initBna() {
        runnable = new Runnable() {

            @Override
            public void run() {
                // handler自带方法实现定时器
                try {
                    handler.postDelayed(this, 3000);
                    advertising.next();
                    advertising.setText(arrList.get(count % arrList.size()));
                    count++;
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
    }

    @Override
    protected IHome.Persenter initPersenter() {
        return new HomePersenter();
    }

    @Override
    protected void initData() {
        persenter.getBannerReturn();
    }

    @Override
    public void getBannerReturn(HomeBannderBean result) {
//        banner.setImages(result.getData().getAdvertiseList())
//                .setImageLoader(new ImageLoader() {
//                    @Override
//                    public void displayImage(Context context, Object path, ImageView imageView) {
//                        path=result.getData().getAdvertiseList().get(0).getPic();
//                        Glide.with(context).load(path).into(imageView);
//                    }
//                }).setDelayTime(2000)
//                .start();
        List<String> title = new ArrayList<>();
        for (HomeBannderBean.DataBean.AdvertiseListBean advertise : result.getData().getAdvertiseList()) {
            title.add(advertise.getName());
        }
        ArrayList<String> list = new ArrayList<>();
        list.add("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=1906469856,4113625838&os=1062705421,520912533&simid=3285371631,209838447&pn=0&rn=1&di=4510&ln=1502&fr=&fmq=1599472000555_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=http%3A%2F%2Fa2.att.hudong.com%2F36%2F48%2F19300001357258133412489354717.jpg&rpstart=0&rpnum=0&adpicid=0&force=undefined");
        banner.setImages(result.getData().getAdvertiseList())
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        HomeBannderBean.DataBean.AdvertiseListBean bean = (HomeBannderBean.DataBean.AdvertiseListBean) path;
                        Glide.with(context).load(bean.getPic()).into(imageView);
                        //imageView.setImageResource(R.mipmap.ic_launcher);
                        //    Glide.with(context).load(R.drawable.xiaoxi).into(imageView);
                    }
                }).setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE).
                setBannerTitles(title)
                .setBannerAnimation(Transformer.Tablet)
                .setDelayTime(5000)
                .start();

        advertiseList = result.getData().getAdvertiseList();
        for (int i = 0; i < advertiseList.size(); i++) {
            arrList.add(advertiseList.get(i).getName());
        }
        initBna();
        handler.postDelayed(runnable, 0);


    }
}

