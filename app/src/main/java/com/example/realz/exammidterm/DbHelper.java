package com.example.realz.exammidterm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by realz on 3/2/2017 AD.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final String databaseName = "dbtodolist.sqlite";
    private static final int databaseVesion = 1;
    Context myContext;

    private static final String SQLCreateTable =
            "CREATE TABLE tbtodo_list (" +
                    "taskid INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT,"+
                    "phone TEXT)";

    public DbHelper(Context context) {
// super(context, name, factory, version);
        super(context, databaseName, null, databaseVesion);
//เมื่อมีการส่งค่ามา ส่วนนี้จะเป็นการรับค่า context
        this.myContext = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLCreateTable);
        /*
         String insertData1 = "INSERT INTO tbtodo_list (name) VALUES ('chalermchai','0918851130')";
        String insertData2 = "INSERT INTO tbtodo_list (name) VALUES ('wasupol','0991192922')";
        String insertData3 = "INSERT INTO tbtodo_list (name) VALUES ('thanakorn','0912229993')";
        String insertData4 = "INSERT INTO tbtodo_list (name) VALUES ('phattravee','0999222002')";
         */

        String insertData1 = "INSERT INTO tbtodo_list (name,phone) VALUES ('chalermchai','0918851130')";
        String insertData2 = "INSERT INTO tbtodo_list (name,phone) VALUES ('wasupol','0918851130')";
        String insertData3 = "INSERT INTO tbtodo_list (name,phone) VALUES ('thanakorn','0918851130')";
        String insertData4 = "INSERT INTO tbtodo_list (name,phone) VALUES ('phattravee','0918851130')";

        db.execSQL(insertData1);
        db.execSQL(insertData2);
        db.execSQL(insertData3);
        db.execSQL(insertData4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
