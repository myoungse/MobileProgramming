package com.example.project1;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setTitle("명화 선호도 투표");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final int voteCount[] = new int[9];
        for (int i = 0; i < 9; i++) {
            voteCount[i] = 0;
        }

        ImageView image[] = new ImageView[9];
        Integer imageId[] = { R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9 };
        final String imgName[] = { "별이 빛나는 밤에", "생베르나르 고개의 나폴레옹", "파라솔을 든 여인", "부부의 초상", "사과바구니가 있는 정물", "에곤실레 자화상", "그랑드자트섬의 일요일 오후", "이렌 캉 당베르 양의 초상화", "두 자매" };

        for (int i = 0; i < imageId.length; i++) {
            final int index = i;
            image[index] = (ImageView) findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),
                            imgName[index] + " : 총 " + voteCount[index] + " 표",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
