package com.herorickystudios.sentimentos;

//Desenvolvido por HeroRickyGames

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EnterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
    }

    public void toMain(View view){

        finish();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}