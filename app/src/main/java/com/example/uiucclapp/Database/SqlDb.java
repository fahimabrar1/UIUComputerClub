package com.example.uiucclapp.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class SqlDb extends SQLiteOpenHelper {

    private static String DB_PATH= "/data/data/com.example.uiucclapp/databases/";
    private static String DB_NAME = "cclapp.db";
    private final Context context;
    private SQLiteDatabase dbObj;
    SqlDb db;


    public SqlDb(Context context) {
        super(context,  DB_NAME , null, 1);
        this.context  = context;
    }

    public static String getDbPath() {
        return DB_PATH;
    }

    public static String getDbName() {
        return DB_NAME;
    }

    public SQLiteDatabase openDB() throws SQLException {

        String myPath = DB_PATH + DB_NAME;
        dbObj = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        return dbObj;
    }


    public String getOptionsQuery(String id)
    {
        String queryString = "SELECT * FROM options WHERE options.Quiz_idQuiz = "+id;
        return queryString;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
