package com.example.fernando.myapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class NovoServicoActivity extends DebugActivity {
    private Spinner spinner;
    private EditText edtNome, edtDescricao;
    private String[] nome = new String[]{"Video","Musica","Curso","Leitura"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_servico);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,nome);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        edtNome = (EditText) findViewById(R.id.edt_novo_servico_nome);
        edtDescricao = (EditText) findViewById(R.id.edt_novo_servico_descricao);
        spinner = (Spinner)findViewById(R.id.spinner_novo_servico);
        spinner.setAdapter(adapter);

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
