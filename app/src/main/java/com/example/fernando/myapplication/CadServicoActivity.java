package com.example.fernando.myapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fernando.myapplication.DAO.ServicoDAO;
import com.example.fernando.myapplication.Model.Servico;
import com.example.fernando.myapplication.adapter.RecyclerViewAdapter;

import java.util.List;

public class CadServicoActivity extends DebugActivity {
    private RecyclerView lstDados;
    private ServicoDAO servicoDAO;
    private RecyclerViewAdapter viewAdapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_servico);
        servicoDAO = new ServicoDAO(this);

        initView();
    }

    private void initView(){
        fab =(FloatingActionButton) findViewById(R.id.fab_cad_servico);
        lstDados = (RecyclerView)findViewById(R.id.acs_recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        lstDados.setLayoutManager(linearLayoutManager);
        List<Servico> servicos = servicoDAO.listar();
        viewAdapter = new RecyclerViewAdapter(servicos,this);
        lstDados.setAdapter(viewAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(CadServicoActivity.this,CadServicoActivity.class);
                startActivity(it);
            }
        });
    }
}
