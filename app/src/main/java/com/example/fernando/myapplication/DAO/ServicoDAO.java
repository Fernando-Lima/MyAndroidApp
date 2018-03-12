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
        dbServico = BancoDados.getDb(context);
    }

    public void salvar(Servico servico) {
        ContentValues values = new ContentValues();
        values.put("nome", servico.getNome());
        values.put("id_categoria", servico.getCategoria().getId());
        values.put("descricao", servico.getDescricao());
        dbServico.insert("tbl_servico", null, values);
    }
    public List<Servico>listar(){
        List<Servico> servicos;
        Cursor c = dbServico.rawQuery("select s._id_servico, s.nome , s.descricao,_id_categoria as idCategoria, c.nome as nomeCategoria\n" +
                "from tbl_categoria c join tbl_servico s\n" +
                "on c._id_categoria = s.id_categoria \n" +
                "order by s.nome;",null);
        servicos = new ArrayList<Servico>();
        if(c.moveToFirst()){
            do {

                Categoria categoria = new Categoria();
                categoria.setId(c.getLong(c.getColumnIndex("idCategoria")));
                categoria.setNome(c.getString(c.getColumnIndex("nomeCategoria")));
                Servico servico = new Servico();
                servico.setId(c.getLong(c.getColumnIndex("_id_servico")));
                servico.setNome(c.getString(c.getColumnIndex("nome")));
                servico.setDescricao(c.getString(c.getColumnIndex("descricao")));
                servico.setCategoria(categoria);

                servicos.add(servico);
            }while (c.moveToNext());
        }
        c.close();
        return servicos;
    }

    public void alterar(Servico servico){
        ContentValues values = new ContentValues();
        values.put("nome", servico.getNome());
        values.put("id_categoria", servico.getCategoria().getId());
        values.put("descricao", servico.getDescricao());
        String[] parametros = new String[1];
        parametros[0] = String.valueOf(servico.getId());

        dbServico.update("tbl_servico",values,"_id = ?",parametros);
    }

    public void excluir(int codigo){
        String[] parametros = new String[1];
        parametros[0] = String.valueOf(codigo);

        dbServico.delete("tbl_servido","_id = ?", parametros);
    }

}