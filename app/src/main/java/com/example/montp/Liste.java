package com.example.montp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

public class Liste extends AppCompatActivity {
    private Button btn1,btn2,btn3;
    private CheckBox all,choix1,choix2;
    private ImageButton dev;
    private TextView dip1,dip2,diplome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        btn1 = findViewById(R.id.btn1);
        dev = findViewById(R.id.dev);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        all = findViewById(R.id.all);
        choix1 = findViewById(R.id.choix1);
        choix2 = findViewById(R.id.choix2);
        dip1 = findViewById(R.id.dip1);
        dip2 = findViewById(R.id.dip2);
        diplome = findViewById(R.id.diplome);

    dev.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                diplome.setText("DIPLOME");
                dip1.setText("Brevet des Technicien superieur");
                dip2.setText("Brevet des Technicien superieur");
            dip1.setWidth(200);
                diplome.setWidth(200);
            dip2.setWidth(200);
            //dev.setImageResource(R.drawable.ic_moin_24dp);
        }
    });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btn1.setBackgroundResource(R.drawable.tablayoutf);
                btn2.setBackgroundResource(R.color.bleugoogle);
                btn3.setBackgroundResource(R.color.bleugoogle);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btn1.setBackgroundResource(R.color.bleugoogle);
                btn2.setBackgroundResource(R.drawable.tablayoutf);
                btn3.setBackgroundResource(R.color.bleugoogle);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btn1.setBackgroundResource(R.color.bleugoogle);
                btn2.setBackgroundResource(R.color.bleugoogle);
                btn3.setBackgroundResource(R.drawable.tablayoutf);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_list, menu);
        return true;
    }


    @Override
    //public boolean onContextItemSelected(@NonNull MenuItem item)
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.close:
                Intent i = new Intent(Liste.this, Login.class);
                startActivity(i);
                return  true;
            case R.id.profil:
                Intent j = new Intent(Liste.this,Profil.class);
                startActivity(j);
                return  true;
            case R.id.acceuil:
                Intent intent = new Intent(Liste.this,MainActivity.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
