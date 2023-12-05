package com.example.growpix;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Management extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);

        // 이미지 및 텍스트 표시를 위한 기존 코드
        ImageView displayImageView = findViewById(R.id.managementimageview);
        TextView textSelect = findViewById(R.id.textSelect);

        // 인텐트로부터 이미지 및 텍스트 데이터 가져오기
        Uri selectedImageUri = getIntent().getData();

        // 이미지 표시
        if (selectedImageUri != null) {
            displayImageView.setImageURI(selectedImageUri);
        }

        // 백엔드에서 가져온 텍스트 설정
        String backendText = "지금 단계는 출뢰기 입니다.\n 열매가 맺히기 전까지 5%\n 남았습니다!";  // 실제 백엔드 텍스트로 교체하세요
        textSelect.setText(backendText);
        textSelect.setGravity(Gravity.CENTER);

        // 추가적인 백엔드에서 가져온 텍스트 설정
        TextView extraTextView = findViewById(R.id.textSelect2);
        String extraBackendText = "출뢰기 관리법\n 출뢰기 때는 물을 많이주면 안됩니다.!\n 출뢰기 때는 비료를 주면 안됩니다.!";
        extraTextView.setText(extraBackendText);
        extraTextView.setGravity(Gravity.CENTER);

        // 홈으로 이동 버튼 설정
        Button homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 홈 액티비티로 이동
                Intent intent = new Intent(Management.this, Main.class);
                startActivity(intent);
                finish(); // 현재 액티비티를 종료하여 뒤로 가기 시 현재 액티비티로 돌아오지 않도록 함
            }
        });
    }
}
