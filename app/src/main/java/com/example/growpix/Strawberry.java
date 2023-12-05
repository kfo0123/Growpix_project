package com.example.growpix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Strawberry extends AppCompatActivity {
    TextView back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strawberry);

        // 뒤로 가기 버튼
        back = findViewById(R.id.mainback);
        back.setOnClickListener(v -> onBackPressed());

        // stselect2 버튼을 위한 코드를 추가합니다
        ImageView stselect2 = findViewById(R.id.stselect2);
        stselect2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // stselect2 버튼이 클릭되었을 때 새로운 액티비티를 시작합니다
                Intent intent = new Intent(Strawberry.this, Strawberrygrow.class);
                startActivity(intent);
            }
        });

        // stselect3 버튼 클릭 시 Managementcamera 액티비티로 전환
        ImageView stselect3 = findViewById(R.id.stselect3);
        stselect3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Managementcamera 액티비티로 전환
                Intent intent = new Intent(Strawberry.this, Managementcamera.class);
                startActivity(intent);
            }
        });

        // stselect4 버튼 클릭 시 Diagnosiscamera 액티비티로 전환
        ImageView stselect4 = findViewById(R.id.stselect4);
        stselect4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Diagnosiscamera 액티비티로 전환
                Intent intent = new Intent(Strawberry.this, Diagnosiscamera.class);
                startActivity(intent);
            }
        });

        // imageView2 및 imageView3에 대한 처리를 추가합니다.
        ImageView imageView2 = findViewById(R.id.imageView2);
        ImageView imageView3 = findViewById(R.id.imageView3);

        // imageView2를 클릭했을 때의 동작을 정의합니다.
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 원하는 동작을 여기에 추가합니다.
            }
        });

        // imageView3를 클릭했을 때의 동작을 정의합니다.
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 원하는 동작을 여기에 추가합니다.
            }
        });
    }
}
