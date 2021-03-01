package com.s3xygod.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ChaoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chao);
       setTitle("SachManager");
       Thread thread = new Thread(){
           @Override
           public void run() {
               super.run();
               int cho = 0;
               while (cho < 2000){
                   try {
                       sleep(1000);
                   }
                   catch (InterruptedException e){
                       e.printStackTrace();
                   }
                   cho += 600;
               }
               Intent i = new Intent(ChaoActivity.this,DangNhapActivity.class);
               i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
               startActivity(i);
               finish();
           }
       };
       thread.start();
    }
}