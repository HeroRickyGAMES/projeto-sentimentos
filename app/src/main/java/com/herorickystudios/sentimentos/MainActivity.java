package com.herorickystudios.sentimentos;

//Desenvolvido por HeroRickyGames

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore referencia = FirebaseFirestore.getInstance();

    EditText editNome, editDRT;
    String sentimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.editNome);
        editDRT = findViewById(R.id.editDRT);

    }
    public void sendToDb(View view){

        Calendar c = Calendar.getInstance();
        String str = c.getTime().toString();

        int dia = c.get(Calendar.MONTH) + 1;

        String calendarioData = c.get(Calendar.DAY_OF_MONTH) + "/" + dia + "/" + c.get(Calendar.YEAR);
        String calendarioDatacomEspacamentos = c.get(Calendar.DAY_OF_MONTH) + " " + dia + " " + c.get(Calendar.YEAR);

        String hora = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND);

        System.out.println(hora + " " + calendarioData);

        String nome = editNome.getText().toString();
        String drt = editDRT.getText().toString();

            if(sentimento == null){

                Toast.makeText(this, "Selecione um sentimento por favor", Toast.LENGTH_SHORT).show();

            }else{
                if(nome.equals("")){

                    System.out.println(sentimento);
                    Toast.makeText(this, "Preencha o seu nome por favor", Toast.LENGTH_SHORT).show();

                }else{
                    if(drt.equals("")){

                        System.out.println(sentimento);
                        Toast.makeText(this, "Preencha o seu DRT por favor", Toast.LENGTH_SHORT).show();

                    }else{

                        String datacomhora = calendarioData + " " + hora;

                        Map<String, Object> user = new HashMap<>();
                        user.put("Nome", nome);
                        user.put("DRT", drt);
                        user.put("Sentimento", sentimento);
                        user.put("Data", datacomhora);

                        DocumentReference setDB = referencia.collection("SentimentosDB").document( drt + " " + calendarioDatacomEspacamentos + " " + hora);

                        setDB.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                                Toast.makeText(MainActivity.this, "Obrigado!", Toast.LENGTH_SHORT).show();

                                if(sentimento.equals("Feliz")){

                                    finish();

                                Intent felizIntent = new Intent(MainActivity.this, felizActivity.class);
                                startActivity(felizIntent);

                                }

                                if(sentimento.equals("Triste")){

                                    finish();

                                    Intent tristeIntent = new Intent(MainActivity.this, tristeActivity.class);
                                    startActivity(tristeIntent);

                                }

                                if(sentimento.equals("Doente")){

                                    finish();

                                    Intent doenteIntent = new Intent(MainActivity.this, doenteActivity.class);
                                    startActivity(doenteIntent);

                                }

                                if(sentimento.equals("Bravo")){

                                    finish();

                                    Intent bravoIntent = new Intent(MainActivity.this, bravoActivity.class);
                                    startActivity(bravoIntent);

                                }

                            }
                        });
                    }
                }

            }

    }
    public void felizBTNString(View view){
        sentimento = "Feliz";
        Toast.makeText(this, "Você selecionou: Feliz", Toast.LENGTH_SHORT).show();
    }
    public void tristeBTNString(View view){
        Toast.makeText(this, "Você selecionou: Triste", Toast.LENGTH_SHORT).show();
        sentimento = "Triste";
    }
    public void doenteBRTNString(View view){
        Toast.makeText(this, "Você selecionou: Doente", Toast.LENGTH_SHORT).show();
        sentimento = "Doente";
    }
    public void bravoBTNString(View view){
        Toast.makeText(this, "Você selecionou: Bravo", Toast.LENGTH_SHORT).show();
        sentimento = "Bravo";
    }
}