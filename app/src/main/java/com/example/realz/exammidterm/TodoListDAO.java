package com.example.realz.exammidterm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by realz on 3/2/2017 AD.
 */

public class TodoListDAO {
    private SQLiteDatabase database;
    private DbHelper dbHelper;

    public TodoListDAO(Context context) {
//get context and sent to helper
        dbHelper = new DbHelper(context);

    }

    //open database
    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        database.close();
    }

    public ArrayList<TodoList> getAlltodoList(){
        ArrayList<TodoList> todoList = new ArrayList<TodoList>();
        Cursor cursor = database.rawQuery("SELECT * FROM tbtodo_list;",null);
        cursor.moveToFirst();
//add TodoList
        TodoList todoList1;
        while (!cursor.isAfterLast()){
//add TodoList
            todoList1 = new TodoList();
            todoList1.setTaskid(cursor.getInt(0));
            todoList1.setName(cursor.getString(1));
            todoList1.setNum(cursor.getString(2));
            todoList.add(todoList1);
            cursor.moveToNext();
        }
        cursor.close();
        return todoList;
    }

      /*  public ArrayList<String> getAlltodoList(){
            ArrayList<String> todoList = new ArrayList<String>();
            Cursor cursor = database.rawQuery("SELECT * FROM tbtodo_list;",null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){

                todoList.add(cursor.getString(1));
                cursor.moveToNext();
            }
            cursor.close();
            return todoList;
        }*/

    public void add(TodoList todoList) {
        TodoList newTodoList = new TodoList();
        newTodoList = todoList;
        ContentValues values = new ContentValues();

        values.put("name", newTodoList.getName());
        //values.put("phone", newTodoList.getNum());
        this.database.insert("tbtodo_list", null, values);
        Log.d("Todo List Demo :::", "Add OK");
    }
}
