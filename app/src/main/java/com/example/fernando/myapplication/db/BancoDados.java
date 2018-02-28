package com.example.fernando.myapplication.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Fernando on 27/12/2017.
 */

public class BancoDados {
    private static final String NOME_BANCO_USUARIO = "tbl_usuario";
    private static final String NOME_BANCO_SERVICO = "tbl_servico";
    private static final String NOME_BANCO_CATEGORIA = "tbl_categoria";
    private static final String NOME_BANCO_GRUPO = "tbl_grupo";
    private static final int VERSAO_BANCO = 4;
    private static final String[] SCRIPT_DATABASE_DELETE_USUARIO = new String[]{"DROP TABLE IF EXISTS"+ NOME_BANCO_USUARIO};
    private static final String[] SCRIPT_DATABASE_CREATE_USUARIO = new String[] {"create table "+NOME_BANCO_USUARIO+"(_id_usuario integer primary key, nome text, telefone text);"};

    private static final String[] SCRIPT_DATABASE_DELETE_SERVICO = new String[]{"DROP TABLE IF EXISTS"+ NOME_BANCO_SERVICO};
    private static final String[] SCRIPT_DATABASE_CREATE_SERVICO = new String[] {"create table "+NOME_BANCO_SERVICO+"(_id_servico integer primary key, nome text, descricao text, " +
            "id_categoria integer not null , foreign key(id_categoria) references tbl_categoria (_id_categoria));"};

    private static final String[] SCRIPT_DATABASE_DELETE_CATEGORIA = new String[]{"DROP TABLE IF EXISTS"+ NOME_BANCO_CATEGORIA};
    private static final String[] SCRIPT_DATABASE_CREATE_CATEGORIA = new String[] {"create table "+NOME_BANCO_CATEGORIA+"(_id_categoria integer primary key, nome text);"};

    private static final String[] SCRIPT_DATABASE_DELETE_GRUPO = new String[]{"DROP TABLE IF EXISTS"+ NOME_BANCO_GRUPO};
    private static final String[] SCRIPT_DATABASE_CREATE_GRUPO = new String[] {"create table "+NOME_BANCO_GRUPO+"(_id_grupo integer primary key, nome text," +
            "id_servico integer not null, foreign key(id_servico) references "+NOME_BANCO_SERVICO+" (_id_servico));"};

    private static SQLiteDatabase dbUsuario;
    private static SQLiteDatabase dbServico;
    private static SQLiteDatabase dbCategoria;
    private static SQLiteDatabase dbGrupo;

    // Injeta os parâmetros no construtor do SQLiteHelper passando contexto, nome, versão, Script create, Script Delete
    public static SQLiteDatabase getDbUsuario(Context ctx) {
        try {
            if (dbUsuario == null) {
                SQLiteHelper dbHelper = new SQLiteHelper(ctx, NOME_BANCO_USUARIO, VERSAO_BANCO, SCRIPT_DATABASE_CREATE_USUARIO, SCRIPT_DATABASE_DELETE_USUARIO);
                dbUsuario = dbHelper.getWritableDatabase();
                Log.i("banco","bancoDados Usuario banco criado com sucesso");
            }
        }catch (SQLException ex){
            Log.i("banco","Erro ao criar o Banco de Dados USUARIO");
        }

        return dbUsuario;
    }

    public static SQLiteDatabase getDbServico(Context ctx){
        try {
            if (dbServico == null) {
                SQLiteHelper dbHelper = new SQLiteHelper(ctx, NOME_BANCO_SERVICO, VERSAO_BANCO, SCRIPT_DATABASE_CREATE_SERVICO, SCRIPT_DATABASE_DELETE_SERVICO);
                dbServico = dbHelper.getWritableDatabase();
                Log.i("banco","bancoDados Servico banco criado com sucesso");
            }
        }catch (SQLException ex){
            Log.i("banco","Erro ao criar o Banco de Dados Servico");
        }
        return dbServico;
    }

    public static SQLiteDatabase getDBCategoria(Context ctx){
        try {
            if(dbCategoria == null) {
                SQLiteHelper dbHelper = new SQLiteHelper(ctx, NOME_BANCO_CATEGORIA, VERSAO_BANCO, SCRIPT_DATABASE_CREATE_CATEGORIA, SCRIPT_DATABASE_DELETE_CATEGORIA);
                dbCategoria = dbHelper.getWritableDatabase();
                Log.i("banco","bancoDados Categoria banco criado com sucesso");
            }
        }catch (SQLException ex){
            Log.i("banco","Erro ao criar o Banco de Dados Categoria");
        }
         return dbCategoria;
    }

    public static SQLiteDatabase getDBGrupo(Context ctx){
        try {
            if(dbGrupo == null) {
                SQLiteHelper dbHelper = new SQLiteHelper(ctx, NOME_BANCO_GRUPO, VERSAO_BANCO, SCRIPT_DATABASE_CREATE_GRUPO, SCRIPT_DATABASE_DELETE_GRUPO);
                dbGrupo = dbHelper.getWritableDatabase();
                Log.i("banco","bancoDados Grupo banco criado com sucesso");
            }
        }catch (SQLException ex){
            Log.i("banco","Erro ao criar o Banco de Dados Grupo");
        }
        return dbGrupo;
    }
}
