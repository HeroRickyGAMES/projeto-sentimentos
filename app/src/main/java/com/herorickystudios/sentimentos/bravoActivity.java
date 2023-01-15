package com.herorickystudios.sentimentos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class bravoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bravo);
    }
    public void obrigadoAc(View view){
        finish();

        Intent intent = new Intent(this, endActivity.class);
        startActivity(intent);

    }
}