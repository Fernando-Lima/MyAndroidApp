package com.example.fernando.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fernando.myapplication.DAO.ServicoDAO;
import com.example.fernando.myapplication.Model.Servico;

public class Cad_servicoActivity extends DebugActivity {
    public Button btnSalvar;
    public EditText edtNome;
    ServicoDAO servicoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_servico);
        servicoDAO = new ServicoDAO(this);
        edtNome = (EditText)findViewById(R.id.edt_cad_servico_nome);
        btnSalvar = (Button)findViewById(R.id.btn_cad_servico_salvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtNome.getText().toString().equals("")){
                    Log.i("error","Nome do servico em branco");
                    return;
                }else {
                    try {
                        salvar();
                        Log.i("banco","Servico salvo com sucesso");
                    }catch (Exception e){
                        e.printStackTrace();
                        Log.e("banco","Erro "+e);
                    }
                }
            }
        });
    }
    public void salvar(){
        Servico servico = new Servico();
        servico.setNome(edtNome.getText().toString());
        servicoDAO.salvar(servico);
    }
}
