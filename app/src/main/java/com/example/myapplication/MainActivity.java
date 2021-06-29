package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.util.*;
import android.widget.*;
import android.content.*;
import android.view.*;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    public Button button;
    private int count=3;

    EditText user;
    EditText pass;
    Button submit,signup;
    CheckBox ischeck;
    RadioGroup gender_selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//here bundle means that it return something.
        super.onCreate(savedInstanceState);//it need save... Instance coz it can show some value.
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Login");
        //log.d()//it is use to print a message in the logcat.

        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        submit = (Button) findViewById(R.id.submit);
        ischeck = (CheckBox) findViewById(R.id.ischeck);
        gender_selection = (RadioGroup) findViewById(R.id.gender);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int check = gender_selection.getCheckedRadioButtonId();//for checking the radio button
                if (check != -1) {
                    if (ischeck.isChecked()) {//for checking the checkbox
                        validate(user.getText().toString(), pass.getText().toString());
                    } else {
                        Toast.makeText(MainActivity.this, "Please check the checkbox", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please select the gender", Toast.LENGTH_SHORT).show();
                }

                PopupMenu popupMenu = new PopupMenu(getApplicationContext(),v);//we have created an object of popupmenu.
                popupMenu.inflate(R.menu.menu_list);//it will link with the menu list
                popupMenu.setOnMenuItemClickListener(MainActivity.this);
                popupMenu.show();
                

            }
        });

        signup = (Button) findViewById(R.id.Sign_up1);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
    }
    //ctrl+O
    //for checking id and password
    private void validate(String username, String password)
    {
        if((username.equals("Harsh")) && (password.equals("1234") ))
        {
            Intent intent = new Intent(MainActivity.this, ContactList.class);
            startActivity(intent);
        }
        else
        {
            count--;
            Toast.makeText(MainActivity.this,"Wrong Username Or Password",Toast.LENGTH_SHORT).show();
            if(count == 0)
            {
                submit.setEnabled(false);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_add:
                Toast.makeText(getApplicationContext(),"Add",Toast.LENGTH_SHORT).show();
                return true;

                case R.id.menu_delete:
                Toast.makeText(getApplicationContext(),"Delete",Toast.LENGTH_SHORT).show();
                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_add:
                Toast.makeText(getApplicationContext(),"Add",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_delete:
                Toast.makeText(getApplicationContext(),"Delete",Toast.LENGTH_SHORT).show();
                return true;


        }
        return super.onOptionsItemSelected(item);
    }
}