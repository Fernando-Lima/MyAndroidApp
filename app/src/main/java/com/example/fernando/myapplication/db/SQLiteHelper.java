package com.example.fernando.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Fernando on 27/12/2017.
 */

public class SQLiteHelper extends SQLiteOpenHelper {
    private String[] scriptSQLCreate;
    private String[] scriptSQLDelete;

    //Construtor
    public SQLiteHelper(Context context, String name, int version, String[] scriptSQLCreate, String[] scriptSQLDelete) {
        super(context, name, null, version);
        this.scriptSQLCreate = scriptSQLCreate;
        this.scriptSQLDelete = scriptSQLDelete;
    }

    @Override
    /**
     * Cria o banco de dados
     */
    public void onCreate(SQLiteDatabase db) {
        /*int qtdeScripts = scriptSQLCreate.length;
        // Executa cada sql passado como parametro
        for (int i = 0; i < qtdeScripts; i++) {
            db.execSQL(scriptSQLCreate[i]);
            Log.i("banco","SQLiteHelper banco criado com sucesso");
        }*/
        db.execSQL("create table tbl_usuario (_id_usuario integer primary key, nome text, telefone text);");
        db.execSQL("create table tbl_servico (_id_servico integer primary key, nome text, descricao text, " +
                "id_categoria integer not null , foreign key(id_categoria) references tbl_categoria (_id_categoria));");
        db.execSQL("create table tbl_categoria (_id_categoria integer primary key, nome text);");
    }

    @Override
    /**
     * Atualiza o banco da dados
     */
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        int qtdeScripts = scriptSQLDelete.length;
        // Executa cada sql passado como parametro
        for (int i = 0; i < qtdeScripts; i++) {
            db.execSQL(scriptSQLDelete[i]);
            Log.i("banco","Drop db");
        }
        onCreate(db);
        Log.i("banco","update db");
    }

}
