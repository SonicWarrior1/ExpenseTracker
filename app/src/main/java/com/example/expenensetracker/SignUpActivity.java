package com.example.expenensetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText name,email,pass,phone;
    TextView alert;
    private DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name=findViewById(R.id.name);
        phone=findViewById(R.id.phoneNumber);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        alert=findViewById(R.id.alert);
        dbHandler=new DbHandler(SignUpActivity.this);
    }

    public void signUp(View view){
        String name1=name.getText().toString();
        String phone1=phone.getText().toString();
        String email1=email.getText().toString();
        String pass1=pass.getText().toString();
        if(name1.isEmpty() && phone1.isEmpty() && email1.isEmpty() && pass1.isEmpty()){

            alert.setText("Fill all Fields");
            return;
        }

        dbHandler.addNewUser(name1,phone1,email1,pass1);
        name.setText("");
        phone.setText("");
        email.setText("");
        pass.setText("");

        Intent i=new Intent(SignUpActivity.this,LoginActivity.class);
        startActivity(i);
        finish();
        Toast.makeText(getApplicationContext(),"Sign Up Successful",Toast.LENGTH_LONG).show();
    }
}