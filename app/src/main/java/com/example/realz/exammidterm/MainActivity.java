package com.example.realz.exammidterm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnAdd;
    private ImageButton btnCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = (ImageButton) findViewById(R.id.add_contact);
        btnAdd.setOnClickListener(AddContact);
        btnCon = (ImageButton) findViewById(R.id.contact);
        btnCon.setOnClickListener(Contact);



    }


    private View.OnClickListener AddContact = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(),ContactActivity.class);
            startActivity(intent);
        }
    };

    private View.OnClickListener Contact = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(),ContactList.class);
            startActivity(intent);
        }
    };




}
