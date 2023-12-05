package com.example.growpix;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Intro extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        // 핸들러를 사용하여 2초 후에 로그인 액티비티로 이동
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 로그인 액티비티를 시작하기 위한 인텐트 생성
                Intent intent = new Intent(Intro.this, Login.class);
                startActivity(intent);

                // Intro 액티비티를 종료하여 뒤로 가기로 돌아갈 수 없게 함
                finish();
            }
        }, 2000); // 2초의 지연 시간
    }

    // Intro 액티비티가 일시 중지될 때 호출되는 메서드
    @Override
    protected void onPause() {
        super.onPause();
        // Intro 액티비티를 종료
        finish();
    }
}

