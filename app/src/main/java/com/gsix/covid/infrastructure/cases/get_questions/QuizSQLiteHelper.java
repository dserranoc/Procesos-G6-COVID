package com.gsix.covid.infrastructure.cases.get_questions;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.gsix.covid.domain.contracts.ScoreContract;

public class QuizSQLiteHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "pym.db";

    public QuizSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ScoreContract.ScoreEntry.TABLE_NAME + " (" +
                ScoreContract.ScoreEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ScoreContract.ScoreEntry.COLUMN_NAME + " TEXT NOT NULL," +
                ScoreContract.ScoreEntry.COLUMN_SCORE + " INTEGER NOT NULL)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ScoreContract.ScoreEntry.TABLE_NAME);
        onCreate(db);
    }
}