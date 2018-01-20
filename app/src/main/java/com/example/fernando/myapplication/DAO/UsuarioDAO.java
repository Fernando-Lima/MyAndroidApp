package com.example.fernando.myapplication.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fernando.myapplication.Model.Usuario;
import com.example.fernando.myapplication.db.BancoDados;

/**
 * Created by Fernando on 08/01/2018.
 */

public class UsuarioDAO {
    Boolean checked;
    SQLiteDatabase dbUsuario; // reppresenta a conexão com o banco de dados.

    public UsuarioDAO(Context context){
        dbUsuario = BancoDados.getDbUsuario(context);
    }
    public void salvar(Usuario usuario){
        ContentValues values = new ContentValues();
        values.put("nome", usuario.getNome());
        values.put("telefone", usuario.getTelefone());
        dbUsuario.insert("tbl_usuario",null,values);
    }
    public void excluir(){

    }
    public Usuario buscarTudoUsuario(){
        String[] colunas = new String[]{"_id", "nome","telefone"};
        Cursor cursor = dbUsuario.query("tbl_usuario",colunas,"cod = 1",null,null,null,null);
        Usuario usuario =  new Usuario();

        if(cursor.moveToFirst()){
            do {
                usuario.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                usuario.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return usuario;
    }
    public boolean checarTabela(){
        Cursor c = dbUsuario.rawQuery("SELECT COUNT(*) FROM tbl_usuario", null);
        if(c != null){
            c.moveToFirst();
            if(c.getInt(0) == 0){
                checked = false;
            }else{
                checked = true;
            }
        }
        return checked;
    }

}
