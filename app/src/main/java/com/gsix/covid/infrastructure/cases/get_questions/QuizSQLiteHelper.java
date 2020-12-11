package com.gsix.covid.infrastructure.cases.get_questions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;

import com.gsix.covid.domain.contracts.ScoreContract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizSQLiteHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "pym2.db";

    public QuizSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ScoreContract.ScoreEntry.TABLE_NAME + " (" +
                ScoreContract.ScoreEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ScoreContract.ScoreEntry.COLUMN_NAME + " TEXT NOT NULL," +
                ScoreContract.ScoreEntry.COLUMN_DATE + " TEXT NOT NULL," +
                ScoreContract.ScoreEntry.COLUMN_SCORE + " INTEGER NOT NULL)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ScoreContract.ScoreEntry.TABLE_NAME);
        onCreate(db);
    }

    public List<Pair<String, String>> getAll(SQLiteDatabase db) {
        List<Pair<String, String>> result = new ArrayList<>();
        @SuppressLint("Recycle")
        Cursor cursor = db.rawQuery("SELECT * FROM " + ScoreContract.ScoreEntry.TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String date = cursor.getString(cursor.getColumnIndex(ScoreContract.ScoreEntry.COLUMN_DATE));
                String score = cursor.getString(cursor.getColumnIndex(ScoreContract.ScoreEntry.COLUMN_SCORE));
                result.add(new Pair<>(date, score));
                cursor.moveToNext();
            }
        }
        return result;
    }

}