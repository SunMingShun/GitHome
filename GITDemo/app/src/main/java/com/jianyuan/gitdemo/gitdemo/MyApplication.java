package com.jianyuan.gitdemo.gitdemo;


import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import com.umeng.commonsdk.UMConfigure;

public class MyApplication extends Application {
    public static int screenWidth;
    public static int screenHeight;
    public static String IP_PORT;

    @Override
    public void onCreate() {
        super.onCreate();
        UMConfigure.init(this,UMConfigure.DEVICE_TYPE_PHONE, "你在友盟申请的UMENG_MESSAGE_SECRET");
//        PushAgent mPushAgent = PushAgent.getInstance(this);
//        mPushAgent.setResourcePackageName("你应用的applicationId");
//        mPushAgent.register(new IUmengRegisterCallback() {
//            @Override
//            public void onSuccess(String s) {
//                Log.e("获取token成功:",s);
//            }
//
//            @Override
//            public void onFailure(String s, String s1) {
//                Log.e("获取token失败:",s+"且s1="+s1);
//            }
//        });
    }

    public static void getAndroiodScreenProperty(Context context) {
        DisplayMetrics display=context.getResources().getDisplayMetrics();
        screenWidth=display.widthPixels;
        screenHeight=display.heightPixels;
    }
}