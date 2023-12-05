package com.example.growpix;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.security.MessageDigest;

public class Main extends AppCompatActivity {
    TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 딸기 이미지 버튼 클릭 시 Strawberry 액티비티로 이동
        ImageButton strawberryBtn = findViewById(R.id.strawberry_btn);
        strawberryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Strawberry 액티비티로 이동하는 Intent 생성
                Intent intent = new Intent(Main.this, Strawberry.class);
                startActivity(intent);
            }
        });


        // 다음 라인을 호출하여 키 해시를 가져옵니다.
        getAppKeyHash();
    }

    private void getAppKeyHash() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                Log.e("Hash key", something);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            Log.e("name not found", e.toString());
        }
    }

    // Method to handle Button_1 click
    public void onButton1Click(View view) {
        // Start the main activity
        Intent intent = new Intent(Main.this, Main.class);
        startActivity(intent);
    }

    // Method to handle Button_2 click
    public void onButton2Click(View view) {
        // Start the history activity
        Intent intent = new Intent(Main.this, History.class);
        startActivity(intent);
    }
}
