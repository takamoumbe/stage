package com.example.montp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView info;
    private ImageView icone;
    int statut = 0;
    Handler handle = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = findViewById(R.id.info);
        icone = findViewById(R.id.icone);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(statut < 100){
                    statut +=1;
                    handle.post(new Runnable() {
                        @Override
                        public void run() {
                            if (statut>=0){
                                icone.setImageResource(R.drawable.ic_spa_dasdp);
                                info.setText("Rassurer vous de la confidentialite de vos informations");
                            }

                            if (statut>=40){
                                icone.setImageResource(R.drawable.ic_security_dashdp);
                                info.setText("Derniere mise a jour 16/01/2022");
                            }

                            if (statut>=80){
                                icone.setImageResource(R.drawable.ic_school_dash24dp);
                                info.setText("04 models d'attestations de stage disponible");
                            }
                        }
                    });
                    try {
                            Thread.sleep(670);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mon_menu, menu);
        return true;
    }

    @Override
    //public boolean onContextItemSelected(@NonNull MenuItem item)
    public boolean onOptionsItemSelected(MenuItem item) {
        //AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.close:
                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);
                return  true;
            case R.id.profil:
                Intent j = new Intent(MainActivity.this,Profil.class);
                startActivity(j);
                return  true;
            case R.id.liste:
                Intent intent = new Intent(MainActivity.this,Liste.class);
                startActivity(intent);
            default:
                //return super.onContextItemSelected(item);
                return super.onOptionsItemSelected(item);
        }
    }
}
