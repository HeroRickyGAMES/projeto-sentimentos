package com.herorickystudios.sentimentos;

//Desenvolvido por HeroRickyGames

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class EnterActivity extends AppCompatActivity {

    FirebaseFirestore referencia = FirebaseFirestore.getInstance();
    String appversionserver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        versaodoapp();
    }

    public void toMain(View view){

        finish();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
    public void versaodoapp(){
        referencia.collection("Server").document("ServerValues").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                DocumentSnapshot document = task.getResult();

                if(document.exists()){

                    appversionserver = document.getString("app-version");
                    String versionName = BuildConfig.VERSION_NAME;

                    System.out.println(versionName);
                    System.out.println(appversionserver);

                    if(!appversionserver.equals(versionName)){

                        new AlertDialog.Builder(EnterActivity.this)
                                .setTitle("A versão do aplicativo em seu dispositivo está desatualizada!")
                                .setMessage("A versão do aplicativo em seu dispositivo está desatualizada, por favor, atualize o seu aplicativo! ( A versão que você está usando é a " +"*"+ versionName + "*" + " ). " + " Mas a versão mais atual é  " + "*" +  appversionserver + "*" + "\n\n" + "Por favor, atualise o app, porque diversos bugs e diversas coisas podem mudar de versão para versão, e permanecer numa versão antiga pode lhe causar problemas com o uso do app!" + "\n")
                                .setCancelable(false)
                                .setPositiveButton("Atualizar app", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        String url = "https://github.com/HeroRickyGAMES/projeto-sentimentos/releases";
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        startActivity(i);

                                    }
                                }).show();

                    }
                }

            }
        });
    }

}