package com.example.growpix;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Splash_management extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_management);

        // GIF 이미지를 표시할 ImageView
        ImageView gif_image = findViewById(R.id.splashImageView);

        // Glide를 사용하여 GIF 이미지 로드
        Glide.with(this)
                .asGif() // GIF 형식으로 로딩 설정
                .load(R.drawable.splash)
                .into(gif_image);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 일정 시간(예: 3초)이 지난 후에 Management 액티비티로 이동
                Intent intent = new Intent(Splash_management.this, Management.class);

                // Managementcamera에서 전달받은 데이터를 그대로 전달
                intent.setData(getIntent().getData());
                startActivity(intent);

                // 현재 액티비티 종료
                finish();
            }
        }, 10000); // 10초 후에 Management 액티비티로 이동
    }
}
