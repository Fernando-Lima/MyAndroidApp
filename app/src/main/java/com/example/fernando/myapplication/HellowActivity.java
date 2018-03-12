package com.example.fernando.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fernando.myapplication.DAO.CategoriaDAO;
import com.example.fernando.myapplication.DAO.GrupoDAO;
import com.example.fernando.myapplication.DAO.ServicoDAO;
import com.example.fernando.myapplication.DAO.UsuarioDAO;
import com.example.fernando.myapplication.Model.Categoria;
import com.example.fernando.myapplication.Model.Servico;
import com.example.fernando.myapplication.Model.Usuario;

public class HellowActivity extends DebugActivity {
    private EditText edtNomeUsuario, edtTelefoneUsuario;
    private Button btnSalvar;
    private Button btnIniciar;

    private UsuarioDAO usuarioDAO;
    private CategoriaDAO categoriaDAO;
    private ServicoDAO servicoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hellow);
        getSupportActionBar().hide(); // Esconde a Action Bar

        usuarioDAO = new UsuarioDAO(this);
        categoriaDAO = new CategoriaDAO(this);
        servicoDAO = new ServicoDAO(this);

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
                        Log.e("banco", "Erro ao salvar USUARIO"+e);
                    }
                    startActivity(new Intent(HellowActivity.this,MainActivity.class));
                    finish();
                }

            }
        });
        try{
            //salvarCategoria();
            //salvarServico();
            Log.i("banco", "servico salvo com sucesso");
        }catch (Exception e){
            e.printStackTrace();
            Log.e("banco", "Erro ao salvar categoria"+e);
        }
    }
    public void salvarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNome(edtNomeUsuario.getText().toString());
        usuario.setTelefone(edtNomeUsuario.getText().toString());
        usuarioDAO.salvar(usuario);
    }
    public void salvarCategoria(){
        Categoria categoria = new Categoria();
        categoria.setNome("Leitura");
        categoriaDAO.salvar(categoria);
    }
    public void salvarServico(){
        Categoria categoria = new Categoria();
        categoria.setId((long)5);
        Servico servico = new Servico();
        servico.setNome("Revista Abril");
        servico.setDescricao("informação");
        servico.setCategoria(categoria);
        servicoDAO.salvar(servico);
    }
}
