package com.example.joovictorfirmino.bancodedados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by João Victor Firmino on 09/11/2017.
 */

public class ContatoDAO {
    private ContatoDbHelper contatoDbHelper;

    public ContatoDAO(Context context){
        this.contatoDbHelper = new ContatoDbHelper(context);
    }

    public boolean inserirContato(Contato garota){
        SQLiteDatabase db = this.contatoDbHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(ContatoContract.COLUNA_NOME, garota.getNome());
        valores.put(ContatoContract.COLUNA_TELEFONE, garota.getTelefone());
        valores.put(ContatoContract.COLUNA_INFO, garota.getInfos());
        long linhas = db.insert(ContatoContract.NOME_TABELA, null, valores);
        return linhas != -1;
    }
    public boolean deleteContato(Integer id){
        SQLiteDatabase db = this.contatoDbHelper.getWritableDatabase();
        String condicao = ContatoContract.COLUNA_ID + " = ?";
        String[] argus = {id.toString()};

        long linhas = db.delete(ContatoContract.NOME_TABELA, condicao, argus);
        return linhas > 0;
    }
    public boolean editarContato(Contato garota){
        SQLiteDatabase db = this.contatoDbHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(ContatoContract.COLUNA_NOME, garota.getNome());
        valores.put(ContatoContract.COLUNA_TELEFONE, garota.getTelefone());
        valores.put(ContatoContract.COLUNA_INFO, garota.getInfos());

        String condicao = ContatoContract.COLUNA_ID + " = ?";
        String[] argus = {garota.getId().toString()};

        long linhas = db.update(ContatoContract.NOME_TABELA, valores, condicao, argus);
        return  linhas != -1;
    }
    public ArrayList<Contato> buscarTodosContatos(){
        SQLiteDatabase db = this.contatoDbHelper.getReadableDatabase();
        String[] colunas = {ContatoContract.COLUNA_ID, ContatoContract.COLUNA_NOME, ContatoContract.COLUNA_TELEFONE, ContatoContract.COLUNA_INFO};

        Cursor cursor = db.query(ContatoContract.NOME_TABELA, colunas, null, null, null, null, ContatoContract.COLUNA_NOME + " ASC");
        ArrayList<Contato> garota = new ArrayList<Contato>();
        while (cursor.moveToNext()){
            Contato contato = new Contato();
            contato.setId(cursor.getInt(cursor.getColumnIndex(ContatoContract.COLUNA_ID)));
            contato.setNome(cursor.getString(cursor.getColumnIndex(ContatoContract.COLUNA_NOME)));
            contato.setTelefone(cursor.getString(cursor.getColumnIndex(ContatoContract.COLUNA_TELEFONE)));
            contato.setInfos(cursor.getString(cursor.getColumnIndex(ContatoContract.COLUNA_INFO)));
            garota.add(contato);
        }
        cursor.close();
        return garota;
    }
}