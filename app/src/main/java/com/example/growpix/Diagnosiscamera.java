package com.example.growpix;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Diagnosiscamera extends AppCompatActivity {
    TextView back;
    private static final int CAMERA_REQUEST_CODE = 1001;
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 1002;
    private static final int GALLERY_REQUEST_CODE = 1;

    // 촬영한 이미지의 Uri를 저장할 변수
    private Uri capturedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosiscamera);

        // 뒤로 가기 버튼
        back = findViewById(R.id.mainback);
        back.setOnClickListener(v -> onBackPressed());

        ImageView camerachoice = findViewById(R.id.managermentchoice);
        camerachoice.setClickable(true);
        ImageView camerachoice2 = findViewById(R.id.managermentchoice2);

        // 카메라 촬영 버튼 클릭 시
        camerachoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 카메라 권한이 부여되어 있는지 확인
                if (ContextCompat.checkSelfPermission(Diagnosiscamera.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    // 권한이 없다면 권한 요청
                    ActivityCompat.requestPermissions(Diagnosiscamera.this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
                } else {
                    // 권한이 있다면 카메라 촬영 시작
                    startCameraIntent();
                }
            }
        });

        // 갤러리 선택 버튼 클릭 시
        camerachoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE);
            }
        });
    }

    // 카메라 촬영 인텐트 시작
    private void startCameraIntent() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        capturedImageUri = createPhotoUri();
        if (capturedImageUri != null) {
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, capturedImageUri);
            startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE);
        }
    }

    // 이미지 파일을 저장할 Uri 생성
    private Uri createPhotoUri() {
        try {
            String fileName = "captured_image.jpg";
            ContentValues values = new ContentValues();
            values.put(MediaStore.Images.Media.TITLE, fileName);
            return getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 카메라 또는 갤러리에서 결과 받아오기
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
            // 촬영한 이미지를 Display1 액티비티에 전달
            startDisplayActivity(capturedImageUri);
        } else if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            if (selectedImageUri != null) {
                Log.d("Cameraset", "Selected image from gallery: " + selectedImageUri.toString());
                startDisplayActivity(selectedImageUri);
            } else {
                Log.d("Cameraset", "Selected image from gallery URI is null");
            }
        }
    }

    // Splash_diagnosis 액티비티 시작 및 이미지 전달
    private void startDisplayActivity(Uri selectedImageUri) {
        Intent displayIntent = new Intent(this, Splash_diagnosis.class);

        if (selectedImageUri != null) {
            displayIntent.setData(selectedImageUri);
            startActivity(displayIntent);
        }
    }

    // 카메라 권한 요청 결과 처리
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 권한이 부여되면 카메라 촬영 시작
                startCameraIntent();
            } else {
                // 권한이 거부되면 사용자에게 알림 또는 다른 조치를 취함
            }
        }
    }
}
