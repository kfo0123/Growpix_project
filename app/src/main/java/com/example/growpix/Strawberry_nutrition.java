package com.example.growpix;

import android.widget.ImageView;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Strawberry_nutrition extends AppCompatActivity {

    private Button button1, button2;
    private ImageView imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11;

    private boolean button2Clicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strawberry_nutrition);

        // Button 및 ImageView 초기화
        button1 = findViewById(R.id.Button_1);
        button2 = findViewById(R.id.Button_2);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);
        imageView10 = findViewById(R.id.imageView10);
        imageView11 = findViewById(R.id.imageView11);

        // button1 클릭 시 현재 액티비티(Strawberry_nutrition)를 종료하여 스택에서 제거
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // 현재 액티비티를 종료하여 스택에서 제거
            }
        });

        // button2 클릭 시 페이지로 이동하고 버튼 비활성화
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!button2Clicked) {
                    button2Clicked = true;



                    // 버튼 비활성화
                    button2.setEnabled(false);
                }
            }
        });

        // ImageView 클릭 이벤트 추가
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // imageView4 클릭 시 이동할 페이지 주소를 정의합니다.
                String url = "https://www.coupang.com/np/search?q=%EB%AA%A8%EC%A2%85%ED%8C%90%EB%A7%A4&channel=relate";  // 여기에 이동하고 싶은 주소를 입력하세요.
                openWebPage(url);
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // imageView5 클릭 시 이동할 페이지 주소를 정의합니다.
                String url = "https://browse.gmarket.co.kr/list?category=300023281";  // 여기에 이동하고 싶은 주소를 입력하세요.
                openWebPage(url);
            }
        });

        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // imageView6 클릭 시 이동할 페이지 주소를 정의합니다.
                String url = "https://seed-farm.com/category/%EB%AA%A8%EC%A2%85%ED%8C%90%EB%A7%A4/119/";  // 여기에 이동하고 싶은 주소를 입력하세요.
                openWebPage(url);
            }
        });

        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // imageView7 클릭 시 이동할 페이지 주소를 정의합니다.
                String url = "https://www.coupang.com/np/search?q=%ED%85%83%EB%B0%AD+%ED%9D%99&channel=relate";  // 여기에 이동하고 싶은 주소를 입력하세요.
                openWebPage(url);
            }
        });

        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // imageView8 클릭 시 이동할 페이지 주소를 정의합니다.
                String url = "https://browse.gmarket.co.kr/search?keyword=%ED%9D%99";  // 여기에 이동하고 싶은 주소를 입력하세요.
                openWebPage(url);
            }
        });

        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // imageView9 클릭 시 이동할 페이지 주소를 정의합니다.
                String url = "https://www.google.com/search?q=%ED%99%94%EB%B6%84+%EC%86%8C+%ED%8C%90%EB%A7%A4+%EC%82%AC%EC%9D%B4%ED%8A%B8&sca_esv=587028756&rlz=1C1YTUH_koKR1068KR1069&sxsrf=AM9HkKnmJ6104K8A1vHsDPZj9xc56SUekQ:1701455352323&source=univ&tbm=shop&tbo=u&sa=X&ved=2ahUKEwixi4GP7-6CAxXvc_UHHR9VCGwQ1TV6BAgGEA0&biw=1536&bih=730&dpr=1.25";  // 여기에 이동하고 싶은 주소를 입력하세요.
                openWebPage(url);
            }
        });

        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // imageView10 클릭 시 이동할 페이지 주소를 정의합니다.
                String url = "https://www.google.com/search?q=%ED%99%94%EB%B6%84+%EC%A4%91+%ED%8C%90%EB%A7%A4+%EC%82%AC%EC%9D%B4%ED%8A%B8&sa=X&sca_esv=587028756&rlz=1C1YTUH_koKR1068KR1069&biw=1536&bih=730&tbm=shop&sxsrf=AM9HkKkL70jPFcwMVBF0Fdom33fs8sMZvA%3A1701455367579&ei=ByZqZY_PIqDQ1e8PxZ-p4Aw&ved=0ahUKEwjP7qOW7-6CAxUgaPUHHcVPCswQ4dUDCAg&uact=5&oq=%ED%99%94%EB%B6%84+%EC%A4%91+%ED%8C%90%EB%A7%A4+%EC%82%AC%EC%9D%B4%ED%8A%B8&gs_lp=Egtwcm9kdWN0cy1jYyIb7ZmU67aEIOykkSDtjJDrp6Qg7IKs7J207Yq4SKwPUIsLWIgOcAB4AJABAJgBuQGgAYwFqgEDMC41uAEDyAEA-AEBiAYB&sclient=products-cc";  // 여기에 이동하고 싶은 주소를 입력하세요.
                openWebPage(url);
            }
        });

        imageView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // imageView11 클릭 시 이동할 페이지 주소를 정의합니다.
                String url = "https://www.google.com/search?q=%ED%99%94%EB%B6%84+%EB%8C%80+%ED%8C%90%EB%A7%A4+%EC%82%AC%EC%9D%B4%ED%8A%B8&sa=X&sca_esv=587028756&rlz=1C1YTUH_koKR1068KR1069&biw=1536&bih=730&tbm=shop&sxsrf=AM9HkKmcrEY_IAMcssqHvd1By3r3YVYZFA%3A1701455383419&ei=FyZqZdH2GMiMoASO1b_4DA&ved=0ahUKEwiR3uqd7-6CAxVIBogKHY7qD88Q4dUDCAg&uact=5&oq=%ED%99%94%EB%B6%84+%EB%8C%80+%ED%8C%90%EB%A7%A4+%EC%82%AC%EC%9D%B4%ED%8A%B8&gs_lp=Egtwcm9kdWN0cy1jYyIb7ZmU67aEIOuMgCDtjJDrp6Qg7IKs7J207Yq4SLQIUM0EWNEGcAB4AJABAJgBdaABvwOqAQMwLjS4AQPIAQD4AQGIBgE&sclient=products-cc";  // 여기에 이동하고 싶은 주소를 입력하세요.
                openWebPage(url);
            }
        });
    }

    // 페이지로 이동하는 메소드
    private void openWebPage(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
