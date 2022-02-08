package com.example.montp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Acceuil extends AppCompatActivity {
private ImageView image2;
int statut =0;
private Handler handlle = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        image2 = findViewById(R.id.image2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(statut<100){
                    statut += 1;
                    handlle.post(new Runnable() {
                        @Override
                        public void run() {
                            if(statut >= 30)
                                image2.setImageResource(R.drawable.ic_group_black_24dp);
                            if(statut >= 70)
                            image2.setImageResource(R.drawable.ic_security_black_24dp);
                            if(statut >= 99){
                                Intent intent = new Intent(Acceuil.this,Login.class);
                                startActivity(intent);
                            }
                        }

                    });
                    try{
                        Thread.sleep(90);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
