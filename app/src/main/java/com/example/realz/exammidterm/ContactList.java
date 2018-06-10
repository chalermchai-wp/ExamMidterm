package com.example.realz.exammidterm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactList extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        listView = (ListView) findViewById(R.id.todoList);
    }

    protected void onResume() {
        super.onResume();
        TodoListDAO todoListDAO = new TodoListDAO(getApplicationContext());
        todoListDAO.open();
        ArrayList<TodoList> myList = todoListDAO.getAlltodoList();

        //ArrayAdapter<TodoList> adapter = new ArrayAdapter<String>(getApplicationContext(),
        //  android.R.layout.simple_list_item_1, myList);
        MyListView adapter = new MyListView(this, myList);

        listView.setAdapter(adapter);
        todoListDAO.close();
    }
}
