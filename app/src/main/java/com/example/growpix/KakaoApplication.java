package com.example.growpix;

import android.app.Application;
import com.kakao.sdk.common.KakaoSdk;
public class KakaoApplication extends Application {
    private static KakaoApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        KakaoSdk.init(this, "244cf9e9002f9f5774fad0fb400915b4");
    }
}
