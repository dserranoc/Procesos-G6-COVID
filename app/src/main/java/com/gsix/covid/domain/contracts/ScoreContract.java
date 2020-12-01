package com.gsix.covid.domain.contracts;

import android.provider.BaseColumns;

public final class ScoreContract {

    private ScoreContract() {}

    public static class ScoreEntry implements BaseColumns {
        public static final String TABLE_NAME = "scores";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SCORE = "score";
    }
}