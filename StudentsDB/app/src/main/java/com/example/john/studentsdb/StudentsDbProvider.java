package com.example.john.studentsdb;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by JOHN on 26/11/2017.
 */

public class StudentsDbProvider extends ContentProvider {

    private UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    @Override
    public boolean onCreate() {
        uriMatcher.addURI(StudentDBContract.AUTHORITY,StudentDBContract.PATH,1);
        uriMatcher.addURI(StudentDBContract.AUTHORITY,StudentDBContract.PATH+"/#",2);
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        StudentDBHelper helper = new StudentDBHelper(getContext());
        SQLiteDatabase database = helper.getReadableDatabase();
        switch (uriMatcher.match(uri)){
            case 1:
                break;
            case 2:
                String id = uri.getLastPathSegment();
                selection = "_ID=?";
                selectionArgs[0] = id;
                break;
            default:
                return null;
        }
        Cursor cursor = database.query(StudentDBContract.TABLE_NAME,projection,selection,selectionArgs,null,null,sortOrder);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        SQLiteDatabase database = new StudentDBHelper(getContext()).getWritableDatabase();
        long id = database.insert(StudentDBContract.TABLE_NAME,null,values);
        return Uri.parse(StudentDBContract.CONTENT_URI+id);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
