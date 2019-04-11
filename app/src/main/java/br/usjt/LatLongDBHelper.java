package br.usjt;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LatLongDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "localizacao1.db";
    private static final int DB_VERSION = 1;

    public LatLongDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LatLongCont.createTableLocalizacao());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        db.execSQL(LatLongCont.LocalizacaoTable.DROP_TABLE);
        onCreate(db);
    }
}
