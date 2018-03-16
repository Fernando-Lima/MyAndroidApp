package com.example.fernando.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fernando.myapplication.DAO.CategoriaDAO;
import com.example.fernando.myapplication.DAO.ServicoDAO;
import com.example.fernando.myapplication.Model.Categoria;
import com.example.fernando.myapplication.Model.Servico;
import com.example.fernando.myapplication.adapter.SpinnerAdapter;

import java.util.List;

public class NovoServicoActivity extends DebugActivity {
    private Spinner spinner;
    private EditText edtNome, edtDescricao;
    private Button btnSalvar;
    private CategoriaDAO categoriaDAO;
    private ServicoDAO servicoDAO;
    private List<Categoria> categorias;
    private SpinnerAdapter spinnerAdapter;
    private Long idSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_servico);

        categoriaDAO = new CategoriaDAO(this);
        categorias = categoriaDAO.listar();

        spinnerAdapter = new SpinnerAdapter(this, categorias);

        servicoDAO = new ServicoDAO(this);

        edtNome = (EditText) findViewById(R.id.edt_novo_servico_nome);
        edtDescricao = (EditText) findViewById(R.id.edt_novo_servico_descricao);
        btnSalvar = (Button)findViewById(R.id.btn_novo_servico);

       spinner = (Spinner)findViewById(R.id.spinner_novo_servico);
       spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idSelected = spinnerAdapter.getItemId(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void salvarServico(View view){
        if (edtNome.getText().toString().equals("") || edtDescricao.getText().toString().equals("")){
            Toast.makeText(this,"Campos em branco",Toast.LENGTH_SHORT).show();
            return;
        }else {
            try{
                Categoria categoria = new Categoria();
                categoria.setId(idSelected);
                Servico servico = new Servico();
                servico.setNome(edtNome.getText().toString());
                servico.setDescricao(edtDescricao.getText().toString());
                servico.setCategoria(categoria);
                servicoDAO.salvar(servico);
                Toast.makeText(this,"posicao item => "+ spinner.getSelectedItemId()+ " id obeto => " + idSelected , Toast.LENGTH_SHORT).show();
                finish();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
