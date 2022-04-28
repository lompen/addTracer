package com.example.addtracer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tracer.R;

public class MainActivity extends AppCompatActivity {

    ImageView streaming,download,report,mypage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        streaming = findViewById(R.id.streaming);
        download = findViewById(R.id.report);
        report = findViewById(R.id.report);
        mypage = findViewById(R.id.mypage);


        mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MypageActivity.class);
                startActivity(intent);

            }
        });




    }
}