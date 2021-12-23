package com.example.expenensetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_second);
    }

    public void signup(View view){
        Intent i=new Intent(SecondActivity.this,SignUpActivity.class);
        startActivity(i);
        finish();
    }

    public void login(View view) {
        Intent i=new Intent(SecondActivity.this,LoginActivity.class);
        startActivity(i);
        finish();
    }
}