package br.usjt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LatLongDao {

    private Context context;

    public LatLongDao(Context context){
        this.context = context;
    }
    public List<LatLongLocalizacao> lista(){
        LatLongDBHelper dbHelper = new LatLongDBHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<LatLongLocalizacao> localizacoes = new ArrayList<>();
        String command = String.format(
                Locale.getDefault(),
                "SELECT * FROM %s;",
                LatLongCont.LocalizacaoTable.TABLE_NAME
        );
        Cursor cursor = db.rawQuery(command, null);
        while(cursor.moveToNext()){
            int idLocalizacao = cursor.getInt(cursor.getColumnIndex(String.format(
                    Locale.getDefault(),
                    "%s.%s",
                    LatLongCont.LocalizacaoTable.TABLE_NAME,
                    LatLongCont.LocalizacaoTable.COLUMN_NAME_ID
            )));
            double latitude = cursor.getDouble(cursor.getColumnIndex(String.format(
                    Locale.getDefault(),
                    "%s.%s",
                    LatLongCont.LocalizacaoTable.TABLE_NAME,
                    LatLongCont.LocalizacaoTable.COLUMN_NAME_LATITUDE
            )));
            double longitude = cursor.getDouble(cursor.getColumnIndex(String.format(
                    Locale.getDefault(),
                    "%s.%s",
                    LatLongCont.LocalizacaoTable.TABLE_NAME,
                    LatLongCont.LocalizacaoTable.COLUMN_NAME_LONGITUDE
            )));
            localizacoes.add(new LatLongLocalizacao(idLocalizacao, latitude, longitude));
        }
        cursor.close();
        db.close();
        dbHelper.close();
        return localizacoes;
    }

    public void insertLocalizacao(LatLongLocalizacao localizacao){
        LatLongDBHelper dbHelper = new LatLongDBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LatLongCont.LocalizacaoTable.COLUMN_NAME_LATITUDE, localizacao.getLatitude());
        values.put(LatLongCont.LocalizacaoTable.COLUMN_NAME_LONGITUDE, localizacao.getLongitude());
        db.insert(LatLongCont.LocalizacaoTable.TABLE_NAME, null, values);
        db.close();
        dbHelper.close();
    }
}
