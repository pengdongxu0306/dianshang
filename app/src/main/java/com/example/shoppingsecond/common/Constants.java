package com.example.shoppingsecond.common;





import com.example.shoppingsecond.app.MyApp;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static final String Base_YunUrl = "http://169.254.96.147:8085/";
  //  public static final String Base_LoginUrl = "http://cdwan.cn:9001/";
   // public static final String Base_yunUrl="home/personal_activity.json";
  // public static final String Base_UploadUrl = "http://yun918.cn/study/public/";  //资源上传的基础地址

    //网络缓存的地址
    public static final String PATH_DATA = MyApp.app.getCacheDir().getAbsolutePath() + File.separator + "data";

   public static final String PATH_CACHE = PATH_DATA + "/mall";


    public static int INDEX=-1;

}