package com.example.fernando.myapplication.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.fernando.myapplication.Model.Categoria;
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
        values.put("id_categoria", servico.getIdCategoria());
        values.put("descricao", servico.getDescricao());
        dbServico.insert("tbl_servico", null, values);
    }

    public List<Servico>listars(){
        String[] colunas = new String[]{"_id_servico", "nome","descricao", "id_categoria"};
        List<Servico> servicos;
        Cursor c = dbServico.query("tbl_servico", colunas, null,null,null,null,null);
        servicos = new ArrayList<Servico>();
        if(c.moveToFirst()){
            do {
                Servico servico = new Servico();
                servico.setId(c.getLong(c.getColumnIndex("_id_servico")));
                servico.setNome(c.getString(c.getColumnIndex("nome")));
                servico.setDescricao(c.getString(c.getColumnIndex("descricao")));
                servico.setIdCategoria(c.getLong(c.getColumnIndex("id_categoria")));

                servicos.add(servico);
            }while (c.moveToNext());
        }
        c.close();
        return servicos;
    }
}