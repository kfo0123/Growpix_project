package com.example.growpix;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class Diagnosis extends AppCompatActivity {

    private FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis);

        // ImageView 및 TextView 초기화
        ImageView displayImageView = findViewById(R.id.diagnosisimageView);
        TextView textSelect = findViewById(R.id.textSelect);

        // Intent에서 데이터 검색
        Bitmap capturedImage = getIntent().getParcelableExtra("capturedImage");
        Uri selectedImageUri = getIntent().getData();

        // 이미지를 ImageView에 표시
        if (capturedImage != null) {
            displayImageView.setImageBitmap(capturedImage);
        } else if (selectedImageUri != null) {
            displayImageView.setImageURI(selectedImageUri);
        }

        // 백엔드에서 텍스트를 받아온 경우, "햄버거"를 실제 텍스트로 교체
        String backendText = "해결법 \n 상태가 아주 건강합니다!";  // 백엔드에서 가져온 실제 텍스트로 교체하세요
        textSelect.setText(backendText);
        textSelect.setGravity(Gravity.CENTER);

        // ViewPager 추가
        ViewPager vpPager = findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        // Diagnosis_firstfragment로 이동
        vpPager.setCurrentItem(0);

        // 홈 버튼 추가 및 클릭 이벤트 처리
        Button homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(v -> {
            // Navigate to the HomeActivity
            Intent intent = new Intent(Diagnosis.this, Main.class);
            startActivity(intent);
            finish(); // Optional: Close the current activity if you don't want to go back to it
        });
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static final int NUM_ITEMS = 2;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Diagnosis_firstfragment(); // 수정된 부분
                case 1:
                    return new Diagnosis_secondfragment(); // 수정된 부분
                default:
                    return null;
            }
        }
    }
}
