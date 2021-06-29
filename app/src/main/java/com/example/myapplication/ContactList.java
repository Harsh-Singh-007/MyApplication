package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_SHORT;

public class ContactList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Hero> heroes;
    Button button,btnupdate;
    EditText edthero,edtteam;
    RecycleAdapter recycleAdapter;

    //ListView listView;

    //String[] festival = { "Diwali", "Holi", "Christmas", "Eid", "Baisakhi", "Halloween", "Lohri" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        getSupportActionBar().setTitle("List View");

        recyclerView = findViewById(R.id.Recycler_view);
        edthero = findViewById(R.id.edt_name);
        edtteam = findViewById(R.id.edt_team);
        btnupdate = findViewById(R.id.btn_update);
        heroes = new ArrayList<>();

        //listView = (ListView) findViewById(R.id.list);
        //ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.list_item,R.id.txt_listItem,festival);

        /*

        heroes.add(new Hero(R.drawable.spiderman,"Spiderman","Avengers"));
        heroes.add(new Hero(R.drawable.ironman,"Ironman","Avengers"));
        heroes.add(new Hero(R.drawable.captian,"Captian America","Avengers"));
        heroes.add(new Hero(R.drawable.thor,"Thor","Avengers"));*/

        btnupdate.setOnClickListener(new View.OnClickListener() { //here what we were doing up we are doing here by taking user input.
            @Override
            public void onClick(View v) {
                String hero = edthero.getText().toString();
                String team = edtteam.getText().toString();
                heroes.add(new Hero(hero,team));
                //recycleAdapter.notifyDataSetChanged();
            }
        });


        //MyContactAdapter myContactAdapter = new MyContactAdapter(this,heroes);

        //listView.setAdapter(myContactAdapter);
        //listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          /*  @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = myContactAdapter.getItem(position).toString();
                Toast.makeText(ContactList.this,value,Toast.LENGTH_SHORT).show();
            }
        });*/

        RecycleAdapter recycleAdapter = new RecycleAdapter(this,heroes);
        recyclerView.hasFixedSize();
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(staggeredGridLayoutManager);


        recyclerView.setAdapter(recycleAdapter);



        //Back button
        /*button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactList.this,MainActivity.class);
                startActivity(intent);
            }
        });*/

    }
}