package com.example.fernando.myapplication.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fernando.myapplication.Model.Categoria;
import com.example.fernando.myapplication.db.BancoDados;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fernando on 11/02/2018.
 */

public class CategoriaDAO {
    SQLiteDatabase dbCategoria;

    public CategoriaDAO (Context context){
        dbCategoria = BancoDados.getDb(context);
    }

    public void salvar(Categoria categoria){
        ContentValues values = new ContentValues();
        values.put("nome", categoria.getNome());
        dbCategoria.insert("tbl_categoria",null,values);
    }

    public List<Categoria> listar(){
        String[] colunas = new String[]{"_id_categoria","nome"};
        List<Categoria> categorias;
        Cursor c = dbCategoria.query("tbl_categoria",colunas,null,null,null,null,null);
        categorias = new ArrayList<Categoria>();
        if(c.moveToFirst()){
            do {
                Categoria categoria = new Categoria();
                categoria.setId(c.getLong(c.getColumnIndex("_id_categoria")));
                categoria.setNome(c.getString(c.getColumnIndex("nome")));
                categorias.add(categoria);
            }while (c.moveToNext());
        }
        c.close();
        return categorias;
    }

    public Categoria buscarCategoria(String codigo){


        String[] colunas = new String[]{"_id_categoria","nome"};
        String[] args = new String[]{codigo};

        Cursor cursor = dbCategoria.query("tbl_categoria",colunas,"_id_categoria = ?",args,null,null,null);
        cursor.moveToFirst();
        Categoria categoria = new Categoria();
        categoria.setId(cursor.getLong(cursor.getColumnIndex("_id_categoria")));
        categoria.setNome(cursor.getString(cursor.getColumnIndex("nome")));
        return categoria;
    }

}