package com.example.fernando.myapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.fernando.myapplication.DAO.CategoriaDAO;
import com.example.fernando.myapplication.Model.Categoria;
import com.example.fernando.myapplication.adapter.SpinnerAdapter;

import java.util.List;

public class NovoServicoActivity extends DebugActivity {
    private Spinner spinner;
   // private EditText edtNome, edtDescricao;
    private CategoriaDAO categoriaDAO;
    private List<Categoria> categorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_servico);

        categoriaDAO = new CategoriaDAO(this);
        categorias = categoriaDAO.listar();

       /* edtNome = (EditText) findViewById(R.id.edt_novo_servico_nome);
        edtDescricao = (EditText) findViewById(R.id.edt_novo_servico_descricao);*/

       spinner = (Spinner)findViewById(R.id.spinner_novo_servico);
       spinner.setAdapter(new SpinnerAdapter(this,categorias));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}
