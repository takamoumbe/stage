package com.example.montp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Profil extends AppCompatActivity {
    private EditText name,matricule,email,password,lastPass;
    private TextView info,connecter;
    int statut =0;
    private CardView modifCli;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        name = findViewById(R.id.name);
        matricule = findViewById(R.id.matricule);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        lastPass = findViewById(R.id.lastPass);
        info = findViewById(R.id.info);
        modifCli = findViewById(R.id.modifCli);

        modifCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setBackgroundResource(R.drawable.buttonjolie);
                matricule.setBackgroundResource(R.drawable.avantclique);
                email.setBackgroundResource(R.drawable.avantclique);
                lastPass.setBackgroundResource(R.drawable.avantclique);
                password.setBackgroundResource(R.drawable.avantclique);
            }
        });
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setBackgroundResource(R.drawable.buttonjolie);
                matricule.setBackgroundResource(R.drawable.avantclique);
                email.setBackgroundResource(R.drawable.avantclique);
                lastPass.setBackgroundResource(R.drawable.avantclique);
                password.setBackgroundResource(R.drawable.avantclique);
            }
        });

        matricule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setBackgroundResource(R.drawable.avantclique);
                matricule.setBackgroundResource(R.drawable.buttonjolie);
                email.setBackgroundResource(R.drawable.avantclique);
                lastPass.setBackgroundResource(R.drawable.avantclique);
                password.setBackgroundResource(R.drawable.avantclique);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setBackgroundResource(R.drawable.avantclique);
                matricule.setBackgroundResource(R.drawable.avantclique);
                email.setBackgroundResource(R.drawable.buttonjolie);
                password.setBackgroundResource(R.drawable.avantclique);
                lastPass.setBackgroundResource(R.drawable.avantclique);
            }
        });

        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setBackgroundResource(R.drawable.avantclique);
                matricule.setBackgroundResource(R.drawable.avantclique);
                email.setBackgroundResource(R.drawable.avantclique);
                password.setBackgroundResource(R.drawable.buttonjolie);
                lastPass.setBackgroundResource(R.drawable.avantclique);
            }
        });
        lastPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setBackgroundResource(R.drawable.avantclique);
                matricule.setBackgroundResource(R.drawable.avantclique);
                email.setBackgroundResource(R.drawable.avantclique);
                password.setBackgroundResource(R.drawable.avantclique);
                lastPass.setBackgroundResource(R.drawable.buttonjolie);
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
                                info.setText("Rassurez vous de la confidentialite de vos informations");
                            if (statut>=20)
                                info.setText("SIGS Systeme Informatique de Gestion des Stagiaires");
                            if (statut>=40)
                                info.setText("Avec SIGS vous avez la possibilite:");
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
