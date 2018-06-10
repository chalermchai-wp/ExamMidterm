package com.example.realz.exammidterm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        final EditText Name = (EditText) findViewById(R.id.con_name);
        final EditText Phone = (EditText) findViewById(R.id.con_num);
        final Button newTodoListButton = (Button) findViewById(R.id.submit);

        newTodoListButton.setOnClickListener(new View.OnClickListener() {
                                                 public void onClick(View v) {
                                                     TodoList todoList = new TodoList();
                                                     todoList.setName(String.valueOf(Name.getText()));
                                                     todoList.setNum(String.valueOf(Phone.getText()));
                                                     TodoListDAO todoListDAO = new TodoListDAO(getApplicationContext());
                                                     todoListDAO.open();
                                                     todoListDAO.add(todoList);
                                                     todoListDAO.close();
                                                     finish();
                                                 }
                                             }


        );
    }


}
