package com.example.fernando.myapplication.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.fernando.myapplication.Model.Categoria;
import com.example.fernando.myapplication.db.BancoDados;

import java.util.List;

/**
 * Created by Fernando on 11/02/2018.
 */

public class CategoriaDAO {
    SQLiteDatabase dbCategoria;

    public CategoriaDAO (Context context){
        dbCategoria = BancoDados.getDBCategoria(context);
    }

    public void salvar(Categoria categoria){
        ContentValues values = new ContentValues();
        values.put("nome", categoria.getNome());
        dbCategoria.insert("tbl_categoria",null,values);
    }

}