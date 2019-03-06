package com.jianyuan.gitdemo.gitdemo;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jianyuan.gitdemo.gitdemo.util.QRCodeUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private int i=0;
    private TextView mHelloTV;
    private Banner mBanner;
    private MyImageLoader mMyImageLoader;
    private List<String> list_path = new ArrayList<>();
    private List<String> list_title = new ArrayList<>();
    private ImageView mQrcodeIV ;
    private Bitmap mQrcodeBitmap;//生成的二维码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.mMainActivity = MainActivity.this;
        setContentView(R.layout.activity_main);
        String sn = MyApplication.getSn(MainActivity.this);
        if(!sn.equals("")){
            Log.e("设备sn>>>:",sn);
        }
        Log.e("设备sn>>>:",sn);
        initData();
        init();
    }
    private void initData() {
        list_path.add("https://gss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/zhidao/wh%3D600%2C800/sign=e9873bfca944ad342eea8f81e09220cc/a8ec8a13632762d08fa73daea8ec08fa513dc602.jpg");
        list_path.add("https://gss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/zhidao/wh%3D600%2C800/sign=e9873bfca944ad342eea8f81e09220cc/a8ec8a13632762d08fa73daea8ec08fa513dc602.jpg");
        list_path.add("https://gss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/zhidao/wh%3D600%2C800/sign=e9873bfca944ad342eea8f81e09220cc/a8ec8a13632762d08fa73daea8ec08fa513dc602.jpg");
        list_path.add("https://gss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/zhidao/wh%3D600%2C800/sign=e9873bfca944ad342eea8f81e09220cc/a8ec8a13632762d08fa73daea8ec08fa513dc602.jpg");
        list_title.add("");
        list_title.add("");
        list_title.add("");
        list_title.add("");
    }
    private void init() {
        String content = "https://gss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/zhidao";
        mQrcodeIV = findViewById(R.id.iv_qrcode);
        mQrcodeBitmap = QRCodeUtil.createQRCodeBitmap(content, 350, 350, "UTF-8",
                "H", "1", Color.BLACK, Color.WHITE, null, 0.2F, null);
        mQrcodeIV.setImageBitmap(mQrcodeBitmap);
        mMyImageLoader = new MyImageLoader();
        mBanner = findViewById(R.id.banner);
        //设置样式，里面有很多种样式可以自己都看看效果
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        mBanner.setImageLoader(mMyImageLoader);
        //设置轮播的动画效果,里面有很多种特效,可以都看看效果。
        mBanner.setBannerAnimation(Transformer.Default);
        //轮播图片的文字
        mBanner.setBannerTitles(list_title);
        //设置轮播间隔时间
        mBanner.setDelayTime(5000);
        //设置是否为自动轮播，默认是true
        mBanner.isAutoPlay(true);
        //设置指示器的位置，小点点，居中显示
        mBanner.setIndicatorGravity(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载地址
        mBanner.setImages(list_path)
                //轮播图的监听
                .setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int position) {
                        Toast.makeText(MainActivity.this, "你点了第" + (position + 1) + "张轮播图", Toast.LENGTH_SHORT).show();
                    }
                })
                //开始调用的方法，启动轮播图。
                .start();
    }

    public void acceptPush(String pushData){
          boolean isTop =  isActivityTop(MainActivity.class,MainActivity.this);
          if(isTop){
              Toast.makeText(MainActivity.this, "topName>>>"+isTop, Toast.LENGTH_SHORT).show();
              Log.e("topName>>>:",isTop+"");

          }
    }

    private void getToken(){

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyApplication.mMainActivity = null;
    }
}
