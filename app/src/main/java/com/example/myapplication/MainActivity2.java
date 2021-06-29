package com.example.myapplication;
import java.text.SimpleDateFormat;
import java.util.*;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity2 extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn = findViewById(R.id.btn);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("EEEE ,dd-MM-yyyy hh:mm:ss a");
        String dateTime = simpleDateFormat.format(calendar.getTime());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this,dateTime,Toast.LENGTH_SHORT).show();
                Snackbar.make(v,dateTime,Snackbar.LENGTH_LONG).show();
            }
        });

    }
}