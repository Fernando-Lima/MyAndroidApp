package com.example.fernando.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fernando.myapplication.DAO.UsuarioDAO;
import com.example.fernando.myapplication.Model.Usuario;

public class HellowActivity extends DebugActivity {
    private EditText edtNomeUsuario, edtTelefoneUsuario;
    private Button btnSalvar;
    private Button btnIniciar;

    UsuarioDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hellow);
        getSupportActionBar().hide(); // Esconde a Action Bar

        dao = new UsuarioDAO(this);
        edtNomeUsuario = (EditText)findViewById(R.id.hellow_edt_name);
        edtTelefoneUsuario = (EditText)findViewById(R.id.hellow_edt_telefone);
        btnIniciar =(Button)findViewById(R.id.btn_iniciar);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtNomeUsuario.getText().toString().equals("") && edtTelefoneUsuario.getText().toString().equals("")){
                    Log.i("error","nome do usuário ou telefone em branco");
                    return;
                }else {
                    try {
                        salvarUsuario();
                        Log.i("banco", "Usuario "+ edtNomeUsuario.getText().toString()+" salvo com sucesso");
                    }catch (Exception e){
                        e.printStackTrace();
                        Log.e("banco", "Erro"+e);
                    }
                    startActivity(new Intent(HellowActivity.this,MainActivity.class));
                    finish();
                }

            }
        });
    }
    public void salvarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNome(edtNomeUsuario.getText().toString());
        usuario.setTelefone(edtNomeUsuario.getText().toString());
        dao.salvar(usuario);
    }
}
