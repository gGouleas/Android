package com.example.john.studentsdb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JOHN on 25/11/2017.
 */

public class StudentDBHelper extends SQLiteOpenHelper {


    public StudentDBHelper(Context context){
        super(context, StudentDBContract.DB_NAME, null, StudentDBContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(StudentDBContract.CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + StudentDBContract.TABLE_NAME);
        onCreate(db);
    }
}
