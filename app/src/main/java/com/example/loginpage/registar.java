package com.example.loginpage;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registar extends AppCompatActivity {
     EditText password, username;
     Button register;
     SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar);
           password = findViewById(R.id.Password);
           username = findViewById(R.id.Username);
           register = findViewById(R.id.butonregis);
           preferences = getSharedPreferences("ramcharan",0);


              register.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {

                           String pass = password.getText().toString();
                           String user = username.getText().toString();

                           if(pass.length()>1){
                               SharedPreferences.Editor editor = preferences.edit();
                           editor.putString("password", pass);
                           editor.putString("username", user);
                           editor.apply();
                           Toast.makeText(registar.this,"register data",Toast.LENGTH_SHORT).show();
                               Log.e("Tag","Data:"+ pass+" "+ user);

                       }else
                           {
                               Toast.makeText(registar.this, "Enter Value ", Toast.LENGTH_SHORT).show();

                           }
                  }
              });
    }
}