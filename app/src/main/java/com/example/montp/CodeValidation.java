package com.example.montp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CodeValidation extends AppCompatActivity {
private EditText code;
private TextView infor,annuler;
private ImageView icone;
int statut = 0;
Handler handle = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_validation);

        code = findViewById(R.id.code);
        infor = findViewById(R.id.infor);
        icone = findViewById(R.id.icone);
        annuler = findViewById(R.id.annuler);

        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CodeValidation.this,Login.class);
                startActivity(intent);
            }
        });

        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                code.setBackgroundResource(R.drawable.buttonjolie);
            }
        });

       new Thread(new Runnable() {
           @Override
           public void run() {
               while (statut<100){
                   statut += 1;
                   handle.post(new Runnable() {
                       @Override
                       public void run() {
                           if (statut>=0){
                               infor.setText("Vous allez recevoir le code par mail");
                                icone.setImageResource(R.drawable.ic_keyboard_black_24dp);
                           }
                           if (statut>=30){
                               infor.setText("Verifier votre adresse TakamAnge@gmail.com");
                                icone.setImageResource(R.drawable.ic_email_black24dp);
                       }
                           if (statut>=70){
                               infor.setText("Cette operation peut faire quelque seconde");
                               icone.setImageResource(R.drawable.ic_access_time_black_24dp);
                           }
                           if (statut>=99)
                               statut=0;
                       }
                   });try{
                        Thread.sleep(700);
                   }catch (InterruptedException e){
                       e.printStackTrace();
                   }
               }
           }
       }).start();
    }
}
