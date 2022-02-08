package com.example.montp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.montp.operations.ForgetPass;

public class Login extends AppCompatActivity {
private TextView enregistrer,forget;
    private EditText name,password;
    private TextView info,connecter;
    int statut =0;
    private Button loger;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        loger = findViewById(R.id.loger);
        info = findViewById(R.id.info);
        enregistrer = findViewById(R.id.enregistrer);
        forget = findViewById(R.id.forget);

        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Registrer.class);
                startActivity(intent);
            }
        });


        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, ForgetPass.class);
                startActivity(intent);
            }
        });

        loger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,MainActivity.class);
                startActivity(intent);
            }
        });

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setBackgroundResource(R.drawable.buttonjolie);
                password.setBackgroundResource(R.drawable.avantclique);
            }
        });

        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setBackgroundResource(R.drawable.avantclique);
                password.setBackgroundResource(R.drawable.buttonjolie);
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (statut < 100){
                    statut += 1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (statut>=0)
                                info.setText("Rassurer vous de la confidentialite de vos informations");
                            if (statut>=20)
                                info.setText("SIG Systeme de Gestion des Stagiaires");
                            if (statut>=40)
                                info.setText("Avec SIG vous avez la possibilite:");
                            if (statut>=80)
                                info.setText("Sauvegarder avec assurance les informations des stagiaires");
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
