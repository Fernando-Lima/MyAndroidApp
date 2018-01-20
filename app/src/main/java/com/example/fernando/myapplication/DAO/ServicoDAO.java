package com.example.fernando.myapplication.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fernando.myapplication.Model.Servico;
import com.example.fernando.myapplication.db.BancoDados;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fernando on 15/01/2018.
 */

public class ServicoDAO {
    SQLiteDatabase dbServico;

    public ServicoDAO(Context context) {
        dbServico = BancoDados.getDbServico(context);
    }

    public void salvar(Servico servico) {
        ContentValues values = new ContentValues();
        values.put("nome", servico.getNome());
        dbServico.insert("tbl_servico", null, values);
    }

    public void excluir() {

    }

    public Servico buscarTudoServico() {
        Servico servico = new Servico();
        return servico;
    }
    public List<Servico>listar(){
        String[] colunas = new String[]{"_id", "nome"};
        List<Servico> servicos;
        Cursor c = dbServico.query("tbl_servico", colunas, null,null,null,null,null);
        servicos = new ArrayList<Servico>();
        if(c.moveToFirst()){
            do {
                Servico servico = new Servico();
                servico.setId(c.getLong(c.getColumnIndex("_id")));
                servico.setNome(c.getString(c.getColumnIndex("nome")));
                servicos.add(servico);
            }while (c.moveToNext());
        }
        c.close();
        return servicos;
    }
}