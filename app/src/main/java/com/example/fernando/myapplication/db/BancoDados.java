package com.example.fernando.myapplication.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Fernando on 27/12/2017.
 */

public class BancoDados {
    private static final String NOME_BANCO = "baseDados";
    private static final String NOME_TABELA_USUARIO = "tbl_usuario";
    private static final String NOME_TABELA_SERVICO = "tbl_servico";
    private static final String NOME_TABELA_CATEGORIA = "tbl_categoria";
    private static final String NOME_TABELA_GRUPO = "tbl_grupo";
    private static final int VERSAO_BANCO = 1;

    private static final String[] SCRIPT_DATABASE_DELETE = new String[4];
    private static final String[] SCRIPT_DATABASE_CREATE = new String[4];

    private static SQLiteDatabase dataBase;

    // Injeta os parâmetros no construtor do SQLiteHelper passando contexto, nome, versão, Script create, Script Delete
    public static SQLiteDatabase getDb(Context ctx) {
        SCRIPT_DATABASE_DELETE[0] = "DROP TABLE IF EXISTS "+ NOME_TABELA_USUARIO;
        SCRIPT_DATABASE_DELETE[1] = "DROP TABLE IF EXISTS "+ NOME_TABELA_SERVICO;
        SCRIPT_DATABASE_DELETE[2] = "DROP TABLE IF EXISTS "+ NOME_TABELA_CATEGORIA;
        SCRIPT_DATABASE_DELETE[3] = "DROP TABLE IF EXISTS "+ NOME_TABELA_GRUPO;

        SCRIPT_DATABASE_CREATE[0] = "create table "+NOME_TABELA_USUARIO+"(_id_usuario integer primary key, nome text, telefone text);";
        SCRIPT_DATABASE_CREATE[1] = "create table "+NOME_TABELA_CATEGORIA+"(_id_categoria integer primary key, nome text);";
        SCRIPT_DATABASE_CREATE[2] = "create table "+NOME_TABELA_SERVICO+"(_id_servico integer primary key, nome text, descricao text, " +
                "id_categoria integer not null , foreign key(id_categoria) references tbl_categoria (_id_categoria));";
        SCRIPT_DATABASE_CREATE[3] =  "create table "+NOME_TABELA_GRUPO+"(_id_grupo integer primary key, nome text," +
                "id_servico integer not null, foreign key(id_servico) references "+NOME_TABELA_SERVICO+" (_id_servico));";

        try {
            if (dataBase == null) {
                SQLiteHelper dbHelper = new SQLiteHelper(ctx, NOME_BANCO, VERSAO_BANCO, SCRIPT_DATABASE_CREATE, SCRIPT_DATABASE_DELETE);
                dataBase = dbHelper.getWritableDatabase();
                Log.i("banco","BANCO DE DADOS CRIADO COM SUCESSO!");
            }
        }catch (SQLException ex){
            Log.i("banco","Erro ao criar o Banco de Dados");
        }

        return dataBase;
    }
}