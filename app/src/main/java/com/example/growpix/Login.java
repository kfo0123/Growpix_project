package com.example.growpix;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public class Login extends AppCompatActivity {
    private static final String TAG = "Login";
    private TextView sign;
    private TextView login;
    private View loginButton, logoutButton;
    private TextView nickName;
    private ImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 회원가입 버튼
        sign = findViewById(R.id.signin);
        // 회원가입 버튼 클릭 시, 회원가입 페이지로 이동
        sign.setOnClickListener(v -> {
            Intent intent = new Intent(this, Signup.class);
            startActivity(intent);
        });

        // 로그인 버튼
        login = findViewById(R.id.loginbutton);
        // 로그인 버튼 클릭 시, 메인 페이지로 이동
        login.setOnClickListener(v -> {
            Intent intent = new Intent(this, Main.class);
            startActivity(intent);
        });

        // KakaoLogin 통합
        loginButton = findViewById(R.id.login);
        logoutButton = findViewById(R.id.logout);
        nickName = findViewById(R.id.nickname);
        profileImage = findViewById(R.id.profile);

        // KakaoLogin의 콜백 함수 정의
        Function2<OAuthToken, Throwable, Unit> callback = new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                if (oAuthToken != null) {
                    // KakaoLogin 성공 시 Main 액티비티로 이동
                    Intent intent = new Intent(Login.this, Main.class);
                    startActivity(intent);
                    finish(); // 현재 액티비티 종료
                } else {
                    Log.e(TAG, "invoke: 로그인 실패");
                }
                return null;
            }
        };

        // KakaoLogin 버튼 클릭 리스너
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UserApiClient.getInstance().isKakaoTalkLoginAvailable(Login.this)) {
                    UserApiClient.getInstance().loginWithKakaoTalk(Login.this, callback);
                } else {
                    UserApiClient.getInstance().loginWithKakaoAccount(Login.this, callback);
                }
            }
        });

        // KakaoLogin 로그아웃 버튼 클릭 리스너
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserApiClient.getInstance().logout(new Function1<Throwable, Unit>() {
                    @Override
                    public Unit invoke(Throwable throwable) {
                        updateKakaoLoginUi();
                        return null;
                    }
                });
            }
        });

        // KakaoLogin UI 업데이트 메서드 호출
        updateKakaoLoginUi();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 앱이 화면에서 사라질 때 로그아웃 처리
        UserApiClient.getInstance().logout(new Function1<Throwable, Unit>() {
            @Override
            public Unit invoke(Throwable throwable) {
                updateKakaoLoginUi();
                return null;
            }
        });
    }

    // KakaoLogin UI 업데이트 메서드
    private void updateKakaoLoginUi() {
        UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
            @Override
            public Unit invoke(User user, Throwable throwable) {
                if (user != null) {
                    Log.d(TAG, "invoke: id =" + user.getId());
                    Log.d(TAG, "invoke: email =" + user.getKakaoAccount().getEmail());
                    Log.d(TAG, "invoke: nickname =" + user.getKakaoAccount().getProfile().getNickname());
                    Log.d(TAG, "invoke: gender =" + user.getKakaoAccount().getGender());
                    Log.d(TAG, "invoke: age=" + user.getKakaoAccount().getAgeRange());

                    // 유저 닉네임 설정
                    nickName.setText(user.getKakaoAccount().getProfile().getNickname());
                    // 유저 프로필 이미지 설정
                    Glide.with(profileImage).load(user.getKakaoAccount().getProfile().getThumbnailImageUrl()).circleCrop().into(profileImage);

                    // 로그인 중일 경우
                    loginButton.setVisibility(View.GONE);
                    logoutButton.setVisibility(View.VISIBLE);
                } else {
                    // 로그인 중이 아닐 경우
                    nickName.setText(null);
                    profileImage.setImageBitmap(null);

                    loginButton.setVisibility(View.VISIBLE);
                    logoutButton.setVisibility(View.GONE);
                }
                return null;
            }
        });
    }
}
