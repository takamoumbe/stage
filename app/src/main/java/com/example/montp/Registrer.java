package com.example.montp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.montp.operations.ConnexionBDD;

public class Registrer extends AppCompatActivity {
private EditText name,matricule,email,password;
private TextView info,connecter;
private Button valider;
int statut =0;
Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrer);

        name = findViewById(R.id.name);
        matricule = findViewById(R.id.matricule);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        info = findViewById(R.id.info);
        connecter = findViewById(R.id.connecter);
        valider = findViewById(R.id.valider);

valider.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String nom = name.getText().toString().trim();
        String mat = matricule.getText().toString().trim();
        String mail = email.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if(nom.length()==0){
            Toast.makeText(Registrer.this,"Veuillez renseigner tous ls champs",Toast.LENGTH_LONG).show();
        }else{
            ConnexionBDD bdd= new ConnexionBDD(Registrer.this);
            EmploeModel nouveauEmp = new EmploeModel(null,nom,mat,mail,pass);
            bdd.insererEmployer(nouveauEmp);
            Intent intent = new Intent(Registrer.this,Login.class);
            startActivity(intent);
        }
    }
});


        connecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registrer.this,Login.class);
                startActivity(intent);
            }
        });

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setBackgroundResource(R.drawable.buttonjolie);
                matricule.setBackgroundResource(R.drawable.avantclique);
                email.setBackgroundResource(R.drawable.avantclique);
                password.setBackgroundResource(R.drawable.avantclique);
            }
        });

        matricule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setBackgroundResource(R.drawable.avantclique);
                matricule.setBackgroundResource(R.drawable.buttonjolie);
                email.setBackgroundResource(R.drawable.avantclique);
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
            }
        });

        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setBackgroundResource(R.drawable.avantclique);
                matricule.setBackgroundResource(R.drawable.avantclique);
                email.setBackgroundResource(R.drawable.avantclique);
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
