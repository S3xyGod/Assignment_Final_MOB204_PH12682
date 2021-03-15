package com.s3xygod.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Chao2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chao2);
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
                    cho += 800;
                }
                Intent i = new Intent(Chao2Activity.this,TrangChuActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
                finish();
            }
        };
        thread.start();
    }
}