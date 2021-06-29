package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.*;
import android.content.*;
import android.view.*;
import android.os.Bundle;
import android.widget.*;

public class Register extends AppCompatActivity {

    public Button button;
    String Name,Last,em;
    int pass;
    CheckBox ischeck;

    EditText first_name,lst_name,password,email;
    Button signup;
    RadioGroup gender_selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Register");

        first_name = (EditText) findViewById(R.id.first_name);
        lst_name = (EditText) findViewById(R.id.lst_name);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        signup = (Button) findViewById(R.id.signup);
        ischeck = (CheckBox) findViewById(R.id.ischeck);
        gender_selection = findViewById(R.id.gender);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name = first_name.getText().toString();
                Last = lst_name.getText().toString();
                em = email.getText().toString();
                pass = Integer.valueOf(password.getText().toString());

                int check = gender_selection.getCheckedRadioButtonId();//for checking the radio button
                if (check != -1) {
                    if (ischeck.isChecked()) {//for checking the checkbox
                        showToast();
                        Intent intent = new Intent(Register.this,MainActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(Register.this,"Please check the checkbox",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(Register.this,"Please select the gender",Toast.LENGTH_SHORT).show();
                }
            }

            private void showToast() {
                Toast.makeText(Register.this,"Id created",Toast.LENGTH_SHORT).show();
            }

        });

        //Signin button
        button = (Button) findViewById(R.id.Sign_in1);//this is what we do to use button.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}