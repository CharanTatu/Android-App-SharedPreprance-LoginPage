package com.example.loginpage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     EditText UserText, PassText;
     Button login, reg;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserText = findViewById(R.id.user);
        PassText = findViewById(R.id.pass);
        login= findViewById(R.id.log);
        reg = findViewById(R.id.regis);

        preferences = getSharedPreferences("ramcharan",0);

         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String username = UserText.getText().toString();
                 String password = PassText.getText().toString();

                 String registervalue = preferences.getString("username","");
                 String regpass = preferences.getString("password","");
                 if(username.equals(registervalue)&& password.equals(regpass))
                 {
                 Intent intent = new Intent(MainActivity.this,homeActivity.class);
                   startActivity(intent);
                 }
                 else{
                     AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                     builder.setTitle("Invalid Username Or Password");
                     Toast.makeText(MainActivity.this,"Invalid Data Not match ",Toast.LENGTH_SHORT).show();
                 }

             }
         });

         reg.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(MainActivity.this, registar.class);
                 startActivity(intent);
             }
         });


    }
}