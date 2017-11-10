package com.example.joovictorfirmino.bancodedados;

import android.provider.BaseColumns;

/**
 * Created by João Victor Firmino on 09/11/2017.
 */

public final class ContatoContract implements BaseColumns {
    private ContatoContract(){}

    public final static  String NOME_TABELA = "contatos";
    public final static  String COLUNA_ID = "_id";
    public final static  String COLUNA_NOME = "nome";
    public final static  String COLUNA_TELEFONE = "telefone";
    public final static  String COLUNA_INFO = "informacao";
}
