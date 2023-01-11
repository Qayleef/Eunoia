package com.example.eunoia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Button btnMotivation, btnToDoList, btnHabit, btnMood, btnMusic;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            username = extras.getString("username");
            //The key argument here must match that used in the other activity
        }
        else{
            username = "Wanderer";
        }

        btnMotivation = findViewById(R.id.btnMotivation);
        btnMotivation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MotivationActivity.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });

        btnToDoList = findViewById(R.id.btnTracker);
        btnToDoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TrackerActivity.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });

        btnHabit = findViewById(R.id.btnRecommendation);
        btnHabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RecomendationActivity.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });

        btnMood = findViewById(R.id.btnHelp);
        btnMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Help.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });

        btnMusic = findViewById(R.id.btnEmergency);
        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EmergencyActivity.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });
    }
}
