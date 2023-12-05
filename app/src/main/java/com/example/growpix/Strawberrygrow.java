    package com.example.growpix;

    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.ImageView;
    import android.widget.TextView;

    import androidx.appcompat.app.AppCompatActivity;

    public class Strawberrygrow extends AppCompatActivity {

        private TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7,
                textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16;

        private Button button1, button2;

        private ImageView imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9;

        TextView back;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_strawberrygrow);

            // 뒤로 가기 버튼
            back = findViewById(R.id.mainback);
            back.setOnClickListener(v -> onBackPressed());

            // TextView 초기화
            textView1 = findViewById(R.id.textView1);
            textView2 = findViewById(R.id.textView2);
            textView3 = findViewById(R.id.textView3);
            textView4 = findViewById(R.id.textView4);
            textView5 = findViewById(R.id.textView5);
            textView6 = findViewById(R.id.textView6);
            textView7 = findViewById(R.id.textView7);
            textView8 = findViewById(R.id.textView8);
            textView9 = findViewById(R.id.textView9);
            textView10 = findViewById(R.id.textView10);
            textView11 = findViewById(R.id.textView11);
            textView12 = findViewById(R.id.textView12);
            textView13 = findViewById(R.id.textView13);
            textView14 = findViewById(R.id.textView14);
            textView15 = findViewById(R.id.textView15);
            textView16 = findViewById(R.id.textView16);

            // ImageView 초기화
            imageView = findViewById(R.id.imageView);
            imageView2 = findViewById(R.id.imageView2);
            imageView3 = findViewById(R.id.imageView3);
            imageView4 = findViewById(R.id.imageView4);
            imageView5 = findViewById(R.id.imageView5);
            imageView6 = findViewById(R.id.imageView6);
            imageView7 = findViewById(R.id.imageView7);
            imageView8 = findViewById(R.id.imageView8);
            imageView9 = findViewById(R.id.imageView9);

            // 버튼 초기화
            button1 = findViewById(R.id.Button_1);
            button2 = findViewById(R.id.Button_2);

            // TextView에 텍스트 설정
            textView1.setText("딸기 키우는 방법");
            textView2.setText("*딸기의 꼭 필요한 준비물*\n\n 식물 모종, 화분 or 화분 받침,\n 갈망, 배양토, 마사토");
            textView3.setText("1. 딸기의 환경 조성하기!\n\n" +
                    "딸기는 기본 흙이 아닌 비료가 섞인 상토를 써야 합니다!\n\n" +
                    "식물을 모종 뿌리 정도로 나머지 흙을 채워 줍니다!");
            textView4.setText("2. 딸기가 좋아하는 곳\n" +
                    "딸기는 양지바른 환경을 선호합니다.\n\n" +
                    "딸기가 건강할 수 있도록 통풍이 잘 되고 햇빛이 잘 들어오는 곳을 배치해 주세요.\n\n");
            textView5.setText("3. 딸기가 좋아하는 햇빛 및 온도\n\n" +
                    "딸기는 햇빛을 많이 받아야 합니다.\n\n" +
                    "햇볕이 잘 드는 장소를 선정해 주시고, 온도는 18~24도 정도가 적당합니다.");
            textView6.setText("Tip 잎이 말라 보인다면 햇볕을 쬐어주고 화분에 물을 듬뿍 주세요.\n\n");
            textView7.setText("4. 딸기가 좋아하는 물 주기\n\n" +
                    "딸기는 수분을 좋아하므로 흙이 말라가면 물을 주세요.\n\n" +
                    "그러나 뿌리가 썩지 않도록 흙을 계속 흠뻑 적시지 않도록 주의해주세요.\n\n");
            textView8.setText("[12~2월] 휴면기\n" +
                    "기온이 떨어짐에 따라 딸기는 휴면기에 들어가게 되는 것입니다. 물을 줄 때는 따뜻한 날 오전 중에 주는 등의 배려를 합시다.\n" +
                    "[3~10월] 생장기\n" +
                    "화분 바닥에서 물이 나올 정도로 푸짐하게 줍시다.\n" +
                    "특히 기온이 높은 시기에는 이른 아침이나 저녁의 시원한 시간대를 골라 충분히 물을 줍니다.\n" +
                    "Tip. 질병 발생을 막기 위해 물을 줄 때 흙이 잎에 튀지 않도록 주의 해주세요.\n\n");
            textView9.setText("5. 딸기의 비료 사용법\n\n" +
                    "성장기에는 약 2주마다 액상 비료를 사용하여 딸기에 필요한 영양분을 공급해 주면 딸기가 건강하게 자랍니다 !");
            textView10.setText("Tip 딸기의 잎이 시들었다면 양분이 조금 부족할 뿐입니다! 비료를 주면 딸기가 건강을 되찾고 훨씬 건강 해집니다 !\n" +
                    "*썩은 잎가 시든 잎은 다릅니다 !*\n\n");
            textView11.setText("6. 딸기의 번식력\n\n" +
                    "딸기는 번식을 위해 잎에서 나는 뿌리인 러너를 만들어 냅니다.\n\n" +
                    "만약! 다른 곳에 모종을 삽목하고 싶으면 뿌리를 내릴 수 있도록 다른 화분과 상토를 준비한 후 뿌리가 내릴 수 있도록 잘 고정해 주세요 !\n\n");
            textView12.setText("*실하게 맺은 열매를 보고 싶다면 러너 줄기를 잘라주세요*");
            textView13.setText("7.딸기의 잎 정리 법\n\n" +
                    "딸기는 자라가면서 불필요한 잎이 자주 생깁니다.\n\n" +
                    "식물의 중앙 부분을 통해 하는 잎을 제거해 줘야 합니다.\n\n" +
                    "불필요한 잎을 제거해 주지 않으면 딸기의 영양분이 불필요한 잎으로 갈 수 있음으로 제거해 줘야 합니다.\n");
            textView14.setText("*열매를 맺기 위해 양분을 쓰기 때문에 잎에 양분이 부족해 썩을 수도 있습니다! 그럴 경우에는 새잎이 자랄 수 있도록 썩은 잎을 제거해 주세요 !*\n\n");
            textView15.setText("8.딸기의 병해충 관리법\n\n" +
                    "주기적으로 딸기를 검사하여 병해충이 발견되면 빠른 조치를 취해주셔야 합니다.\n\n" +
                    "병해충을 치료하기 위해선 영양제나 친환경적인 방법을 사용하시면 됩니다.\n\n");
            textView16.setText("9.딸기의 수확 법\n\n" +
                    "딸기가 익으면 붉게 변하고 부드러워지므로 주기적으로 확인하여 딸기의 익음이 확인되면 조심스럽게 수확해 주시면 됩니다.");

            // button2 클릭 시 Strawberry_nutrition.java로 이동
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Intent를 사용하여 Strawberry_nutrition.java로 이동
                    Intent intent = new Intent(Strawberrygrow.this, Strawberry_nutrition.class);
                    startActivity(intent);
                }
            });
        }

        @Override
        protected void onResume() {
            super.onResume();
            // 화면이 다시 보일 때 버튼 활성화
            button2.setEnabled(true);
        }
    }
