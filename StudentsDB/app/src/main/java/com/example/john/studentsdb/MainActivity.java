package com.example.john.studentsdb;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*        StudentDBHelper helper = new StudentDBHelper(this);
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        database.insert(StudentDBHelper.TABLE_NAME,null,values);
        database.close();
        database = helper.getReadableDatabase();
        String[] columns = {StudentDBHelper.KEY_FNAME,StudentDBHelper.KEY_LNAME};
        String selection = StudentDBHelper.KEY_ID+"=? AND "+ StudentDBHelper.KEY_EYEAR+"=?";
        String[] selectionArgs = {};
        Cursor cursor = database.query(StudentDBHelper.TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        if (cursor.moveToFirst()){
            do{
                Toast.makeText(this,cursor.getString(1),Toast.LENGTH_LONG).show();
            }while(cursor.moveToNext());
        }*/

    }
}
