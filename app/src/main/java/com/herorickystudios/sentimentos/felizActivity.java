package com.herorickystudios.sentimentos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class felizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feliz);
    }

    public void obrigadoAc(View view){
        finish();

        Intent intent = new Intent(felizActivity.this, endActivity.class);
        startActivity(intent);

    }
}