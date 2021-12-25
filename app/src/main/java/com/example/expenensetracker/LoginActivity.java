package com.example.expenensetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText email;
    EditText pass;
    TextView alert;
    DbHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        alert=findViewById(R.id.alert);

    }
    public void verify(View view){
        email=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        String user;
        user=email.getText().toString();

        String password;
        password=dbHandler.getPassword(user);
        alert.setText(password);
//        if(email.getText().toString().equals(user) && pass.getText().toString().equals(password)){
//            Intent i=new Intent(LoginActivity.this,HomeActivity.class);
//            startActivity(i);
//            finish();
//        }
//        else{
//            alert.setText("Wrong Credentials");
//        }
    }
}