package com.example.montp.operations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.montp.CodeValidation;
import com.example.montp.Login;
import com.example.montp.MainActivity;
import com.example.montp.R;
import com.example.montp.Registrer;

public class ForgetPass extends AppCompatActivity {
    private TextView enregistrer,connect;
    private EditText name,password,retype_password;
    private TextView info;
    int statut =0;
    private ImageView icone;
    private Button modifier;
    private CardView cardClik;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);

        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        modifier = findViewById(R.id.modifier);
        info = findViewById(R.id.info);
        connect = findViewById(R.id.connect);
        retype_password = findViewById(R.id.retype_password);
        icone = findViewById(R.id.icone);
        cardClik = findViewById(R.id.cardClik);

        cardClik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setBackgroundResource(R.drawable.buttonjolie);
                retype_password.setBackgroundResource(R.drawable.avantclique);
                password.setBackgroundResource(R.drawable.avantclique);
            }
        });

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgetPass.this, Login.class);
                startActivity(intent);
            }
        });
        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(ForgetPass.this, CodeValidation.class);
                startActivity(intent);
            }
        });

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setBackgroundResource(R.drawable.buttonjolie);
                retype_password.setBackgroundResource(R.drawable.avantclique);
                password.setBackgroundResource(R.drawable.avantclique);
            }
        });

        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setBackgroundResource(R.drawable.avantclique);
                retype_password.setBackgroundResource(R.drawable.avantclique);
                password.setBackgroundResource(R.drawable.buttonjolie);
            }
        });
        retype_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setBackgroundResource(R.drawable.avantclique);
                retype_password.setBackgroundResource(R.drawable.buttonjolie);
                password.setBackgroundResource(R.drawable.avantclique);
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
                                info.setText("Le mot de passe est un moyen de proteges vos donnees");
                            if (statut>=40)
                                icone.setImageResource(R.drawable.ic_vpn_key_black_24dp);
                                info.setText("Rassurer vous de toujours retenir votre mot de passe");
                            if (statut>=80)
                                info.setText("SIGS garantir avec assurance la securites des informations des stagiaires");
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
