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
    /**
     * Cria uma instancia de SQLiteHelper
     *
     * @param context
     * @param nomeBanco nome do banco de dados
     * @param versaoBanco versao do banco de dados (se for diferente para atualizar)
     * @param scriptSQLCreate SQL com o create table..
     * @param scriptSQLDelete SQL com o drop table...
     */

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
        int qtdeScripts = scriptSQLCreate.length;
        // Executa cada sql passado como parametro
        for (int i = 0; i < qtdeScripts; i++) {
            db.execSQL(scriptSQLCreate[i]);
            Log.i("banco","SQLiteHelper banco criado com sucesso");
        }
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
