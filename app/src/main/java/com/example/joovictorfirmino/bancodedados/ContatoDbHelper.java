package com.example.joovictorfirmino.bancodedados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by João Victor Firmino on 09/11/2017.
 */

public class ContatoDbHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE = "CREATE TABLE IF NO EXISTS" + ContatoContract.NOME_TABELA + "( " +
            ContatoContract.COLUNA_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
            ContatoContract.COLUNA_NOME + " TEXT, " +
            ContatoContract.COLUNA_TELEFONE + " TEXT, " +
            ContatoContract.COLUNA_INFO + " TEXT);";

    private static final String SQL_DROP = "DROP TABLE IF EXISTS" + ContatoContract.NOME_TABELA + ";";
    private static final Integer DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "agenda.db";

    public ContatoDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntiga, int versionNova) {
        db.execSQL(SQL_DROP);
        onCreate(db);
    }
}
